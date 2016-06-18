package com.wenfang.contactlist.services;

import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.wenfang.contactlist.dao.ContactDao;
import com.wenfang.contactlist.model.Contact;

public class ContactRestServicesImpl implements ContactRestServices {

	@Autowired
	private ContactDao contactDao;
	
	public Response getContactList() {
		final GenericEntity<List<Contact>> entity = new GenericEntity<List<Contact>>(contactDao.getContactList()) { };
	    return Response.ok(entity).header("Content-Type", "application/json").build();
	}

	public Response getContactDetails(int contactId) {
		if(contactId == -1) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}		
		return Response.ok(contactDao.getContact(contactId)).header("Content-Type", "application/json").build();

	}

}
