package com.wenfang.contactlist.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.wenfang.contactlist.model.Contact;
import com.wenfang.contactlist.model.ContactMessage;

public class ContactDao {
	@Autowired
	private SessionFactory sessionFactory;

	public ContactDao() {
	}

	public List<Contact> getContactList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Contact> result = session.createQuery("from Contact", Contact.class).getResultList();
		session.getTransaction().commit();
		session.close();
		return result;
	}
	
	public Contact getContactDetails(int contactId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Contact contact = session.get(Contact.class, contactId);
		session.getTransaction().commit();
		session.close();
		
		return contact;
	}

	public ContactMessage addContact(Contact contact) {
		if (contactExists(contact)) {
			return new ContactMessage(1,"Failed adding new contact, contact email exists in the system already." );
		}
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(contact.getAddress());
		session.save(contact);
		session.getTransaction().commit();
		session.close();
		
		return new ContactMessage(0,"New contact was successfully added." );
	}
	
	private boolean contactExists(Contact contact) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query<Contact> query = session.createQuery("from Contact where email = :email", Contact.class);
        query.setParameter("email", contact.getEmail());
        List<Contact> result = query.getResultList();
		session.getTransaction().commit();
		session.close();
		return (result.size() > 0);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
