package com.cubic.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cubic.rest.service.CustomerService;
import com.cubic.rest.service.CustomerVO;

@Path("/customer")
@Service
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class CustomerResourse {

	@Autowired
	@Qualifier("csSpringData")
	private CustomerService cs;

	@POST
	
	public Response create(final CustomerVO customer) {
		CustomerVO result = cs.createCustomer(customer);
		return Response.ok().entity(result).build();
	}
	@PUT
	public Response modify(final CustomerVO customer) {
		cs.modifyCustomer(customer);
		return Response.noContent().build();
	}
	
	@GET
	@Path("/{custPK}")
	public Response findCustomer(@PathParam("custPK") final Long pk) {
		CustomerVO result = cs.find(pk);
		return Response.ok().entity(result).build();
	}
	
	@DELETE
	@Path("/{custPK}")
	public Response removeCustomer(@PathParam("custPK") final Long pk) {
		cs.removeCustomer(pk);
		return Response.ok().build();
	}
}
