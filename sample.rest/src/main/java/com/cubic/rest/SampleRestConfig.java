package com.cubic.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.cubic.rest.resources.CustomerResourse;
import com.cubic.rest.resources.HelloWorldResource;

@Configuration
public class SampleRestConfig extends ResourceConfig {

	public SampleRestConfig() {
		this.register(HelloWorldResource.class);
		this.register(CustomerResourse.class);
	}

}
