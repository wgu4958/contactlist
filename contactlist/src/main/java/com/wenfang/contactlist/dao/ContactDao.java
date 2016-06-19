package com.wenfang.contactlist.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wenfang.contactlist.model.Contact;
import com.wenfang.contactlist.model.ContactError;

public class ContactDao {
	private Map<Integer, Contact> contactMap = new HashMap<>();
	private final int capacity = 8;

	public ContactDao() {
		Contact john = new Contact(1, "Jonh", "Smith", "john.smith@yahoo.com", "(212)555-1234");
		Contact susan = new Contact(2, "Susan", "Jones", "susan.jones@yahoo.com", "(646)513-3425");
		Contact bob = new Contact(3, "Bob", "Tylor", "bob.tylor@yahoo.com", "(996)177-7152");
		Contact tom = new Contact(4, "Tom", "Tudor", "tom.tudor@yahoo.com", "(732)434-5455");
		Contact amy = new Contact(5, "Amy", "Miller", "amy.miller@yahoo.com", "(908)545-5774");
		Contact ray = new Contact(6, "Ray", "Caldwell", "bob.tylor@yahoo.com", "(845)245-7895");
		contactMap.put(john.getContactId(), john);
		contactMap.put(susan.getContactId(), susan);
		contactMap.put(bob.getContactId(), bob);
		contactMap.put(tom.getContactId(), tom);
		contactMap.put(amy.getContactId(), amy);
		contactMap.put(ray.getContactId(), ray);
	}

	public List<Contact> getContactList() {
		return new ArrayList<Contact>(contactMap.values());
	}

	public ContactError addContact(Contact contact) {
		Integer id = getNextID();
		if (id == null) {
			return new ContactError(1,"Exceeded max contacts " + capacity + ", cannot add more contact." );
		}
		
		contact.setContactId(id);
		this.contactMap.put(id, contact);
		return null;
	}
	
	public void removeContact(int contactId) {
		contactMap.remove(contactId);
	}
	
	public Contact getContact(int contactId) {
		return contactMap.get(contactId);
	}
	
	//for now, no delete function, so we are OK
	private Integer getNextID() {
		if (contactMap.size() >= capacity)
			return null;
		
		return contactMap.size() + 1;
	}
}
