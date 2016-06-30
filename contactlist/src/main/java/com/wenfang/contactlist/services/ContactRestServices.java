package com.wenfang.contactlist.services;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wenfang.contactlist.model.Contact;

@Path("/")
@WebService(name="contactServices")
public interface ContactRestServices {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/contacts")
	public Response getContactList();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/contacts/{contactId}")
	public Response getContactDetails(@PathParam("contactId")int contactId);
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/contacts")
	public Response addContact(Contact contact);
}
