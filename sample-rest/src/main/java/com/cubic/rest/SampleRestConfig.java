package com.cubic.rest;

import org.springframework.context.annotation.Configuration;
import org.glassfish.jersey.server.ResourceConfig;

import com.cubic.rest.resource.HelloWorld;

@Configuration
public class SampleRestConfig extends ResourceConfig{
	
	public SampleRestConfig() {
		this.register(HelloWorld.class);

	}
}
