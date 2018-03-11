package com.cubic.rest.service;

import java.util.List;

public interface CustomerService {

	CustomerVO createCustomer(final CustomerVO customer);

	void modifyCustomer(final CustomerVO customer);

	CustomerVO find(final Long pk);

	void removeCustomer(final Long pk);

	List<CustomerVO> searchCustomer(final String firstName, final String lastName);
}
