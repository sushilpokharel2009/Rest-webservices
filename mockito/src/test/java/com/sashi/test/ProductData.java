package com.sashi.test;

import com.shashi.entity.ProductEntity;
import com.shashi.vo.ProductVO;

public class ProductData {
	public static ProductVO createProductVO() {
		ProductVO vo = new ProductVO();
		vo.setProductName("Dell Laptop");;
		vo.setDescription("Personal Laptop");
		return vo;
	}

	public static ProductEntity createProductEntity() {
		ProductEntity entity = new ProductEntity();
		entity.setProductName("Dell Laptop");;
		entity.setDescription("Personal Laptop");
		entity.setId(new Long(2000));
		return entity;
	}
}
