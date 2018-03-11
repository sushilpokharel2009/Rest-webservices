package com.cubic.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloWorldResource {
	
	@GET
	public String welcome() {
		return "welcome to Rest Services";
	}
	
}
