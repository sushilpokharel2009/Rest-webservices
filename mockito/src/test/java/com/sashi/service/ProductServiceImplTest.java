package com.sashi.service;

import org.junit.Test;
import org.mockito.Mockito;

import com.sashi.test.ProductData;
import com.shashi.service.ProductServiceImpl;
import com.shashi.vo.ProductVO;

public class ProductServiceImplTest {

	private ProductServiceImpl imp = new ProductServiceImpl();
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductNull() {
		imp.saveProduct(null);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSaveProductNullName() {
		ProductVO input = ProductData.createProductVO();
		
		input.setProductName(null);
		imp.saveProduct(input);
		
	}
	
	
	@Test
	public void testSaveProduct() throws SQL Exception{
		
		ProductVO input = ProductData.createProductVO();
		ProductEntity resultEntity = ProductData.createProductEntity();
		
		ProductDAO mockDao = mock(ProductDAO.class);
		ProductDetailDAO mockDetailDao = mock(ProductDetailDAO.class);
		
		imp.setDao(mockDao);
		imp.setDetailDao(mockDetailDao);
		
		when(mockDao.createProduct(any(ProductEntity.class))).thenReturn(resultEntity);
		
		ProductVO output = imp.saveProduct(input);
		assertNotNull(output.getId);
		assertEquals(output.getProductName(), input.getProductName());
		assertEquals(output.getDescription(), input.getDescription());
		
	}

}


