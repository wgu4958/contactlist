package com.wenfang.contactlist.model;

public class Contact {
	private int contactId;
	private String firstName;
	private String lastName;
	private String email;
	private PhoneNumber phone;
	private Address address;

	public Contact() {
	}

	public Contact(int contactId, String firstName, String lastName) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	} 
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
