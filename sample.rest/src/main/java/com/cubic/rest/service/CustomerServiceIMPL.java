package com.cubic.rest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cubic.rest.entity.CustomerEntity;
import com.cubic.rest.entity.QueryConstant;
import com.cubic.rest.exception.CustomerNotFoundException;

@Service("csJpa")
@Transactional
public class CustomerServiceIMPL implements CustomerService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomerMapper mapper;

	@Override
	public CustomerVO createCustomer(final CustomerVO customer) {
		final CustomerEntity entity = mapper.mapToCustomerEntity(customer);
		em.persist(entity);
		customer.setPk(entity.getId());
		return customer;
	}

	@Override
	public void modifyCustomer(final CustomerVO customer) {
		CustomerEntity entity = em.find(CustomerEntity.class, customer.getPk());
		entity = mapper.mapToCustomerEntity(entity, customer);
		em.persist(entity);

	}

	@Override
	public CustomerVO find(Long pk) {
		final CustomerEntity entity = getCustomer(pk);
		return mapper.mapToCustomerVO(entity);
	}

	public void removeCustomer(final Long pk) {
		final CustomerEntity entity = getCustomer(pk);
		// em.persist(entity);
		em.remove(entity);
	}

	@Override
	public List<CustomerVO> searchCustomer(String firstName, String lastName) {
		
			firstName = StringUtils.isEmpty(firstName) ? "%": firstName.trim() + "%";
			lastName = StringUtils.isEmpty(lastName) ? "%": lastName.trim() + "%";
			final TypedQuery<CustomerEntity> query = em.createNamedQuery(QueryConstant.CUSTOMER_SEARCH_QUERY,
					CustomerEntity.class);
			query.setParameter("fName", firstName);
			query.setParameter("lName", lastName);
			final List<CustomerEntity> results = query.getResultList();
			return mapper.mapToCustomerVOList(results);
		

		
	}
	
	private CustomerEntity getCustomer(final Long pk) {
		final CustomerEntity entity = em.find(CustomerEntity.class, pk);
		if(entity==null) {
			throw new CustomerNotFoundException("Customer not found" + pk);
		}
		return entity;
	}

}
