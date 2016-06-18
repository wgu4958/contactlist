package com.wenfang.contactlist.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.jws.WebService;

@Path("/")
@WebService(name="contactServices")
public interface ContactRestServices {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getcontactlist")
	public Response getContactList();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/getcontactdetails")
	public Response getContactDetails(@QueryParam("contactId") int contactId);
}
