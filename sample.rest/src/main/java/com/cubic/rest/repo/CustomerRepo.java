package com.cubic.rest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cubic.rest.entity.CustomerEntity;

public interface CustomerRepo extends CrudRepository<CustomerEntity, Long>{
	
	@Query("select c from CustomerEntity c where UPPER (c.firstName) like UPPER(?1) AND UPPER(c.lastName) like UPPER(?1")
	List<CustomerEntity> search(final String firstName, final String  lastName);
}
