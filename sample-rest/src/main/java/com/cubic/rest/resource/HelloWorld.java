package com.cubic.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloWorld {

	@GET
	public String Welcome() {
		return "Welcome to hello world of rest !!";
	}
}
