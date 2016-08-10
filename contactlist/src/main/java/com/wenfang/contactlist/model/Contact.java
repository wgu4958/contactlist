package com.wenfang.contactlist.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable {

	private static final long serialVersionUID = 5180297071521525928L;
	
	public static final int ACTIVE = 0;
	public static final int DELETED = 1;
	public static final int DISABLED = 2;
	
	@Id
	@Column(name="CONTACTID")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	protected Integer contactId;
	
	@Column(name="FIRSTNAME")
	protected String firstName;
	
	@Column(name="LASTNAME")
	protected String lastName;
	
	@Column(name="EMAIL")
	protected String email;
	
	@Column(name="PHONE")
	protected String phone;
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ADDRESSID", unique=true, nullable=false, updatable=false)
	private Address address;
	
	@Column(name="STATUS")
	private int status = ACTIVE;
	
	@Version
	@Column(name="LAST_UPDATED")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public Contact() {
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
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
