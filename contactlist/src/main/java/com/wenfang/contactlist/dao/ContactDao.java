package com.wenfang.contactlist.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wenfang.contactlist.model.Contact;
import com.wenfang.contactlist.model.ContactMessage;

public class ContactDao {
	private Map<String, Contact> contactMap = new HashMap<>();
	private final int capacity = 20;

	public ContactDao() {
		
		//initial contact list
		Contact john = new Contact(1, "Jonh", "Smith", "john.smith@yahoo.com", "2125551234");
		Contact susan = new Contact(2, "Susan", "Jones", "susan.jones@yahoo.com", "6465133425");
		Contact bob = new Contact(3, "Bob", "Tylor", "bob.tylor@yahoo.com", "9961777152");
		Contact tom = new Contact(4, "Tom", "Tudor", "tom.tudor@yahoo.com", "7324345455");
		Contact amy = new Contact(5, "Amy", "Miller", "amy.miller@yahoo.com", "9085455774");
		Contact ray = new Contact(6, "Ray", "Caldwell", "bob.tylor@yahoo.com", "8452457895");
		contactMap.put(john.getEmail(), john);
		contactMap.put(susan.getEmail(), susan);
		contactMap.put(bob.getEmail(), bob);
		contactMap.put(tom.getEmail(), tom);
		contactMap.put(amy.getEmail(), amy);
		contactMap.put(ray.getEmail(), ray);
	}

	public List<Contact> getContactList() {
		return new ArrayList<Contact>(contactMap.values());
	}

	public ContactMessage addContact(Contact contact) {
		if (contactExists(contact)) {
			return new ContactMessage(1,"Failed adding new contact, contact email exists in the system already." );
		}
		
		Integer id = getNextID();
		if (id == null) {
			return new ContactMessage(2,"Exceeded max contacts " + capacity + ", cannot add more contact." );
		}
		
		contact.setContactId(id);
		this.contactMap.put(contact.getEmail(), contact);
		return new ContactMessage(0,"New contact was successfully added." );
	}
	
	private boolean contactExists(Contact contact) {
		return contactMap.containsKey(contact.getEmail());
	}
	
	//for now, no delete function, so we are OK
	private Integer getNextID() {
		if (contactMap.size() >= capacity)
			return null;
		
		return contactMap.size() + 1;
	}
}
