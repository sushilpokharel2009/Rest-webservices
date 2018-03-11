package com.vendor.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:SpringJPA.xml"})
public class VendorApplication {

	public static void main(String[] args) {
		SpringApplication.run(VendorApplication.class,args);

	}

}
