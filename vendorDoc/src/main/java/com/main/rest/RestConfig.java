package com.main.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.vendor.rest.resource.VendorResource;

@Configuration
public class RestConfig extends ResourceConfig {
	public RestConfig() {
		this.register(VendorResource.class);

	}

}



