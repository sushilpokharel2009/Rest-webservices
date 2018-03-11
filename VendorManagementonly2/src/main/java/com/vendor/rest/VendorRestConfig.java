package com.vendor.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.vendor.rest.resource.VendorResource;

@Configuration
public class VendorRestConfig extends ResourceConfig {

	public VendorRestConfig() {
		this.register(VendorResource.class);
		
		
		
	}

	

}
