package com.wenfang.contactlist.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wenfang.contactlist.model.Address;
import com.wenfang.contactlist.model.Contact;
import com.wenfang.contactlist.model.ContactMessage;

public class ContactDaoTest {
	private static ContactDao contactDao;
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("/config/*.xml");
		contactDao = (ContactDao)context.getBean("contactDao");
		System.out.println();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		((ClassPathXmlApplicationContext)context).close();
	}

	@Test
	public void testGetContactList() {
		List<Contact> contactList = contactDao.getContactList();
		Assert.assertNotNull(contactList);
	}

	@Test
	public void testGetContactDetails() {
		Contact contact = contactDao.getContactDetails(2);
		Assert.assertNotNull(contact);
		Assert.assertTrue(contact.getFirstName().equals("Wenfang"));
	}

	@Test()
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
		ContactMessage message = contactDao.addContact(contact);
		Assert.assertNotNull(message);
	}

}
