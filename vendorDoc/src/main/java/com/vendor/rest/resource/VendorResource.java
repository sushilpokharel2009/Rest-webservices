package com.vendor.rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vendor.rest.entity.VendorEntity;
import com.vendor.rest.service.VendorService;
import com.vendor.rest.vo.VendorVO;

@Path("/vendor")
@Service
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ MediaType.APPLICATION_JSON })

public class VendorResource {
	
	@Autowired
	private VendorService vs;
	
	
	@POST
	public Response create(final VendorVO vendor) {
		VendorVO vo = vs.createVendor(vendor);
		return Response.ok().entity(vo).build();
	}
	
//	@PUT
//	public Response update(@PathParam("update")final VendorVO vendor) {
//			vs.updateVendor(vendor);
//			return Response.noContent().build();
//	}
	@PUT
	public Response update(final VendorVO vendor) {
			vs.updateVendor(vendor);
			return Response.noContent().build();
	}
	
	@GET
	@Path("/{venPK}")
	public Response findById(@PathParam("venPK") final Long pk) {
		VendorVO result1 = vs.findVendorById(pk);
		return Response.ok().entity(result1).build();
	}
	
	@GET
	@Path("/find/{vendorPK}")
	public Response findByCode(@PathParam("vendorPK") final String code ) {
		VendorEntity result2 = vs.findVendorByCode(code);
		return Response.ok().entity(result2).build();
	}
	
	@PUT
	@Path("/active/{id}")
	public Response activeVendor(@PathParam("id") final Long pk) {
		vs.activateVendor(pk);
		return Response.ok().build();
	}
	
	
	@PUT
	@Path("/deactive/{id}")
	public Response deactiveVendor(@PathParam("id") final Long pk) {
		vs.deActivateVendor(pk);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/{active}")
	public Response searchactiveVendor(Long active) {
		List<VendorVO> results = vs.searchActiveVendor(activeVendor(active));
		return Response.ok().entity(results).build();
	}
	
	@GET
	public Response searchByName(@QueryParam("vendorName") final String vendorName) {
		List<VendorVO> results = vs.searchVendorByName(vendorName);
		return Response.ok().entity(new VendorSearchResult(results)).build();
	}
	
	@GET
	public Response searchByAddress(@QueryParam("streetAddress") final String streetAddress) {
		List<VendorVO> result = vs.searchVendorByAddress(streetAddress);
		return Response.ok().entity(new VendorSearchResult(result)).build();
	}
	
	@GET
	public Response searchByCity(@QueryParam("city") final String city) {
		List<VendorVO> res = vs.searchVendorByCity(city);
		return Response.ok().entity(new VendorSearchResult(res)).build();
	}
	
	@GET
	public Response searchByState(@QueryParam("state") final String state) {
		List<VendorVO> rest = vs.searchVendorByState(state);
		return Response.ok().entity(new VendorSearchResult(rest)).build();
	}
}
