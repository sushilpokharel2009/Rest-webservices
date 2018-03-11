package com.cubic.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.rest.entity.CustomerEntity;
import com.cubic.rest.repo.CustomerRepo;

@Service("ctTransaction")
@Transactional(propagation = Propagation.SUPPORTS)
public class ChildTransaction implements CustomerTransaction {

	@Autowired
	private CustomerRepo repo;

	@Override
	@Transactional(propagation = Propagation.NEVER)
	public void createCustomer() {
		save("Child", "Transaction");
		// throw new RuntimeException("roll back");
	}

	private void save(final String firstName, final String lastName) {
		CustomerEntity entity = new CustomerEntity();
		entity.setFristName(firstName);
		entity.setLastName(lastName);
		repo.save(entity);
	}

}
