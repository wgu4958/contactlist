package com.wenfang.contactlist.services;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wenfang.contactlist.model.Address;
import com.wenfang.contactlist.model.Contact;

public class ContactRestServicesImplTest {

	private static ContactRestServicesImpl contactServiceImpl;
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("/config/*.xml");
		contactServiceImpl = (ContactRestServicesImpl)context.getBean("contactServiceImpl");
		System.out.println();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		((ClassPathXmlApplicationContext)context).close();
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetContactList() {
		Response response = contactServiceImpl.getContactList();
		Assert.assertNotNull(response);
		Assert.assertTrue(response.getStatus() == 200);
	}

	@Test
	public void testAddContact() {
		Contact contact = new Contact();
		contact.setFirstName("Testing First Name");
		contact.setLastName("Testing Last Name");
		contact.setPhone("1234567890");
		contact.setEmail("testing@gmail.com");
		
		contact.setStatus(Contact.ACTIVE);
		
		Address address = new Address();
		address.setStreet("100 Main St.");
		address.setCity("Some City");
		address.setState("CA");
		address.setZipcode("12345");
		
		contact.setAddress(address);
		Response response = contactServiceImpl.addContact(contact);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.getStatus() == 200);
	}

	@Test
	public void testGetContactDetails() {
		Response response = contactServiceImpl.getContactDetails(2);
		Assert.assertNotNull(response);
		Assert.assertTrue(response.getStatus() == 200);
		Assert.assertTrue(((Contact)response.getEntity()).getContactId() == 2);
	}

}
