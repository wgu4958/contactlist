package com.wenfang.contactlist.services;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.wenfang.contactlist.model.Contact;

import javax.jws.WebService;

@Path("/")
@WebService(name="contactServices")
public interface ContactRestServices {

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/contacts")
	public Response getContactList();
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/contacts")
	public Response addContact(Contact contact);
}
