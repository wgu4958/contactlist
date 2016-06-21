package com.wenfang.contactlist.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wenfang.contactlist.model.Address;
import com.wenfang.contactlist.model.Contact;
import com.wenfang.contactlist.model.ContactDetails;
import com.wenfang.contactlist.model.ContactMessage;

public class ContactDao {
	private Map<Integer, Contact> contactMap = new HashMap<>();
	private Map<Integer, ContactDetails> contactDetailsMap = new HashMap<>();
	
	private final int capacity = 200;

	public ContactDao() {
		
		//initial contact list
		Contact contact = new Contact(1, "Jonh", "Smith", "john.smith@yahoo.com", "9085551234");
		contactMap.put(contact.getContactId(), contact);
		ContactDetails details = new ContactDetails(1, "Jonh", "Smith", "john.smith@yahoo.com", "9085551234");
		details.setAddress(new Address(1, "20 Main St", "Bridgewater", "NJ", "08875"));
		contactDetailsMap.put(contact.getContactId(), details);
		
		contact = new Contact(2, "Susan", "Jones", "susan.jones@yahoo.com", "9086454656");
		contactMap.put(contact.getContactId(), contact);
		details = new ContactDetails(2, "Susan", "Jones", "susan.jones@yahoo.com", "9086454656");
		details.setAddress(new Address(2, "30 Hastings Rd", "Hillsborogh", "NJ", "08575"));
		contactDetailsMap.put(contact.getContactId(), details);
		
		contact = new Contact(3, "Bob", "Tylor", "bob.tylor@yahoo.com", "6091777152");
		contactMap.put(contact.getContactId(), contact);
		
		details = new ContactDetails(3, "Bob", "Tylor", "bob.tylor@yahoo.com", "6091777152");
		details.setAddress(new Address(3, "25 Mattrews Farm Rd", "Belle Mead", "NJ", "08502"));
		contactDetailsMap.put(contact.getContactId(), details);
		
		contact = new Contact(4, "Tom", "Tudor", "tom.tudor@yahoo.com", "6094396455");
		contactMap.put(contact.getContactId(), contact);
		
		details = new ContactDetails(4, "Tom", "Tudor", "tom.tudor@yahoo.com", "6094396455");
		details.setAddress(new Address(4, "245 Dale St", "Princeton", "NJ", "08012"));
		contactDetailsMap.put(contact.getContactId(), details);
		
		contact = new Contact(5, "Amy", "Miller", "amy.miller@yahoo.com", "6096214656");
		contactMap.put(contact.getContactId(), contact);
		
		details = new ContactDetails(5, "Amy", "Miller", "amy.miller@yahoo.com", "6096214656");
		details.setAddress(new Address(5, "32 Harvard Rd", "Skillman", "NJ", "08530"));
		contactDetailsMap.put(contact.getContactId(), details);
		
		contact = new Contact(6, "Ray", "Caldwell", "bob.tylor@yahoo.com", "9086454638");
		contactMap.put(contact.getContactId(), contact);
		
		details = new ContactDetails(6, "Ray", "Caldwell", "bob.tylor@yahoo.com", "9086454638");
		details.setAddress(new Address(6, "12 Hastings Rd", "Belle Mead", "NJ", "08502"));
		contactDetailsMap.put(contact.getContactId(), details);
	}

	public List<Contact> getContactList() {
		return new ArrayList<Contact>(contactMap.values());
	}
	
	public ContactDetails getContactDetails(int contactId) {
		return contactDetailsMap.get(contactId);
	}

	public ContactMessage addContact(ContactDetails contact) {
		if (contactExists(contact)) {
			return new ContactMessage(1,"Failed adding new contact, contact email exists in the system already." );
		}
		
		Integer id = getNextID();
		if (id == null) {
			return new ContactMessage(2,"Exceeded max contacts " + capacity + ", cannot add more contact." );
		}
		
		contact.setContactId(id);
		contactDetailsMap.put(contact.getContactId(), contact);
		
		if (contact.getAddress() != null)
			contact.getAddress().setAddressId(id);
		
		Contact cont = new Contact(contact.getContactId(), contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhone());
		contactMap.put(cont.getContactId(), cont);
		
		return new ContactMessage(0,"New contact was successfully added." );
	}
	
	private boolean contactExists(Contact contact) {
		for (Contact con: contactMap.values()) {
			if (con.getEmail().equalsIgnoreCase(contact.getEmail())){
				return true;
			}
		}
		return false;
	}
	
	//for now, no delete function, so we are OK
	private Integer getNextID() {
		if (contactMap.size() >= capacity)
			return null;
		
		return contactMap.size() + 1;
	}
}
