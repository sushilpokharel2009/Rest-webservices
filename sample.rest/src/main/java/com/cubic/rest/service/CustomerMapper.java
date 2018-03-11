package com.cubic.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cubic.rest.entity.CustomerEntity;

@Component
public class CustomerMapper {
	
	public CustomerEntity mapToCustomerEntity(final CustomerVO vo) {
		return mapToCustomerEntity(new CustomerEntity(),vo);
	}
	
	public CustomerEntity mapToCustomerEntity(final CustomerEntity entity,final CustomerVO vo) {
		entity.setFristName(vo.getFirstName());
		entity.setLastName(vo.getLastName());
		return entity;
	}

	public CustomerVO mapToCustomerVO(final CustomerEntity entity) {
		CustomerVO result = new CustomerVO();
		result.setFirstName(entity.getFristName());
		result.setLastName(entity.getLastName());
		result.setPk(entity.getId());
		return result;
 
}

	public List<CustomerVO> mapToCustomerVOList(List<CustomerEntity> entityList) {
		final List<CustomerVO> results = new ArrayList<CustomerVO>();
		for (CustomerEntity entity : entityList) {
			results.add(mapToCustomerVO(entity));
		}
		return results;
	}
	
	
}
