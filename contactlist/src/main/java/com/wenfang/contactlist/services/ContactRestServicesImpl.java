package com.wenfang.contactlist.services;

import java.util.List;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.wenfang.contactlist.dao.ContactDao;
import com.wenfang.contactlist.model.Contact;
import com.wenfang.contactlist.model.ContactDetails;
import com.wenfang.contactlist.model.ContactMessage;

public class ContactRestServicesImpl implements ContactRestServices {

	@Autowired
	private ContactDao contactDao;
	
	@Override
	public Response getContactList() {
		final GenericEntity<List<Contact>> entity = new GenericEntity<List<Contact>>(contactDao.getContactList()) { };
	    return Response.ok(entity).header("Content-Type", "application/json").build();
	}

	@Override
	public Response addContact(ContactDetails contact) {
		ContactMessage message = contactDao.addContact(contact);
		return Response.ok(message).header("Content-Type", "application/json").build();
	}

	@Override
	public Response getContactDetails(int contactId) {
		ContactDetails contactDetails = contactDao.getContactDetails(contactId);	
		return Response.ok(contactDetails).header("Content-Type", "application/json").build();
	}
}
