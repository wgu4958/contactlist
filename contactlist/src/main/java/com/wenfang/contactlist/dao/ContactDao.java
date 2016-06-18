package com.wenfang.contactlist.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wenfang.contactlist.model.Contact;

public class ContactDao {
	private Map<Integer, Contact> contactMap = new HashMap<>();

	public ContactDao() {
		Contact contact = new Contact(1, "Jonh", "Smith");
		contactMap.put(1, contact);
	}

	public List<Contact> getContactList() {
		return new ArrayList<Contact>(contactMap.values());
	}

	public void addContact(Contact contact) {
		this.contactMap.put(contact.getContactId(), contact);
	}
	
	public void removeContact(int contactId) {
		contactMap.remove(contactId);
	}
	
	public Contact getContact(int contactId) {
		return contactMap.get(contactId);
	}
}
