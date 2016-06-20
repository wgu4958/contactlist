package com.wenfang.contactlist.model;

import java.util.List;

public class Contact {
	private Integer contactId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private Address address;
	private List<PhoneNumber> phoneNumbers;

	public Contact() {
	}

	public Contact(Integer contactId, String firstName, String lastName, String email, String phone) {
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
