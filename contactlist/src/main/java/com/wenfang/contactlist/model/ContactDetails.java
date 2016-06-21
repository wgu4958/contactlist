package com.wenfang.contactlist.model;

public class ContactDetails extends Contact {
	private Address address;
	
	public ContactDetails() {
	}

	public ContactDetails(Integer contactId, String firstName, String lastName, String email, String phone) {
		super(contactId, firstName, lastName, email, phone);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
