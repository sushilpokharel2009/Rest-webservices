package com.cubic.rest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cubic.rest.entity.CustomerEntity;
import com.cubic.rest.exception.CustomerNotFoundException;
import com.cubic.rest.repo.CustomerRepo;

@Service("csSpringData")
@Transactional
public class CustomerServiceSpringDataImpl implements CustomerService{
	
		@Autowired
		private CustomerRepo repo;
		
		@Autowired
		private CustomerMapper mapper;
		
		@Override
		public CustomerVO createCustomer(final CustomerVO customer) {
			final CustomerEntity entity =mapper.mapToCustomerEntity(customer);
//			em.persist(entity);
			repo.save(entity);
			customer.setPk(entity.getId());
			return customer;
		}
		
		@Override
		public void modifyCustomer( final CustomerVO customer) {
			CustomerEntity entity=getCustomer( customer.getPk());
			entity=mapper.mapToCustomerEntity(entity,customer);
			repo.save(entity);

		}

		@Override
		public CustomerVO find(final Long pk) {
			final CustomerEntity entity= getCustomer (pk);
			return mapper.mapToCustomerVO(entity);
//			repo.find(entity);
		}

		public void removeCustomer(final Long pk) {
			final CustomerEntity entity= getCustomer (pk);
			//em.persist(entity);
			repo.delete(entity);
		}

		@Override
		public List<CustomerVO> searchCustomer(String firstName, String lastName) {
			firstName = StringUtils.isEmpty(firstName) ? "%": firstName.trim() + "%";
			lastName = StringUtils.isEmpty(lastName) ? "%": firstName.trim() + "%";
			final List<CustomerEntity> results = repo.search(firstName, lastName);
			return mapper.mapToCustomerVOList(results);
		}

	private CustomerEntity getCustomer(final Long pk) {
		final CustomerEntity entity = getCustomer (pk);
		if(entity==null) {
			throw new CustomerNotFoundException("Customer not found" + pk);
		}
		return entity;
	}

}
