package com.wenfang.contactlist.services;

import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.wenfang.contactlist.dao.ContactDao;
import com.wenfang.contactlist.model.Contact;
import com.wenfang.contactlist.model.ContactError;

public class ContactRestServicesImpl implements ContactRestServices {

	@Autowired
	private ContactDao contactDao;
	
	@Override
	public Response getContactList() {
		final GenericEntity<List<Contact>> entity = new GenericEntity<List<Contact>>(contactDao.getContactList()) { };
	    return Response.ok(entity).header("Content-Type", "application/json").build();
	}

	@Override
	public Response addContact(Contact contact) {
		ContactError errorMsg = contactDao.addContact(contact);
		if (errorMsg == null) 
			return Response.ok().header("Content-Type", "application/json").build();
		
		return Response.status(Response.Status.BAD_REQUEST).entity(errorMsg).build();
	}

}
