package com.cubic.rest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cubic.rest.service.CustomerTransaction;

public class TransactionTest {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("SpringJPA.xml");
		CustomerTransaction pt = context.getBean("pt", CustomerTransaction.class);
		pt.createCustomer();
		
	}
}