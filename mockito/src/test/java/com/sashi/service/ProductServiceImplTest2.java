
package com.sashi.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.sashi.test.ProductData;

import dao.ProductDAO;
import dao.ProductDetailDAO;
import entity.ProductEntity;
import service.ProductServiceImpl;
import service.exception.ProductException;
import vo.ProductVO;


@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest2 {

	@Mock
	private ProductDAO mockDAO;
	@Mock
	private ProductDetailDAO mockDetailDAO;
	
	@Spy
	private ProductVO input = null;
	private ProductEntity resultEntity = null;
	private ProductServiceImpl impl = new ProductServiceImpl();

	@Before
	public void setup() {
		input = ProductData.createProductVO();
		resultEntity = ProductData.createProductEntity();
		when(imp.getDao()).thenReturn(mockDAO);
		when(imp.getDetailDao()).thenReturn(mockDetailDAO);
		imp.setDao(mockDAO);
		imp.setDetailDao(mockDetailDAO);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductNull() {
		imp.saveProduct(null);
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductNullName() {
		input.setProductName(null);
		imp.saveProduct(input);
		
	}

	@Test
	public void testSaveProduct() throws SQLException {
		when(mockDAO.createProduct(any(ProductEntity.class))).thenReturn(resultEntity);
		ProductVO output = imp.saveProduct(input);
		validateOutput(output);
		InOrder inorder = inOrder(mockDAO, mockDetailDAO);
		inorder.verify(mockDAO, times(1)).createProduct(any(ProductEntity.class));
		inorder.verify(mockDetailDAO).saveProductDetail(any(ProductEntity.class));
		verify(mockDAO, never()).find(any(Long.class));
		verify(mockDAO, never()).updateProduct(any(ProductEntity.class));
	}

	private void validateOutput(ProductVO output) {
		assertNotNull(output);
		assertNotNull(output.getId());
		assertEquals(output.getProductName(), input.getProductName());
		assertEquals(output.getDescription(), input.getDescription());
	}

	@Test
	public void testSaveProductUpdate() throws SQLException {
		input.setId(new Long (2000));
		input.setProductName("ABC Laptop");
		when(mockDAO.find(any(Long.class))).thenReturn(resultEntity);
		ProductVO output = imp.saveProduct(input);
		validateOutput(output);
		
		InOrder inorder = inOrder(mockDAO, mockDetailDAO);
		inorder.verify(mockDAO).find(any(Long.class));
		inorder.verify(mockDAO).updateProduct(any(ProductEntity.class));
		
		inorder.verify(mockDetailDAO).saveProductDetail(any(ProductEntity.class));
		verify(mockDAO,never()).createProduct(any(ProductEntity.class));

		
	}

	@Test(expected=ProductException.class)
	public void testSaveProductException() throws SQLException {
		input.setId(new Long (2000));
		input.setProductName("ABC Laptop");
		when(mockDAO.find(any(Long.class))).thenThrow(new SQLException("Data base not found"));
		imp.saveProduct(input);
		
	}
}

