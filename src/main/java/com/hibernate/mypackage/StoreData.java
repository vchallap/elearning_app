package com.hibernate.mypackage;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {

	public static void main(String[] args) throws HibernateException {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Employee e1 = new Employee(); // transient, persistent, Detached CRUD

		e1.setId(201);
		e1.setFirstName("Venkatesh");
		e1.setLastName("Challapalli");

		session.persist(e1);
		t.commit();
		session.close();

		System.out.println("successfully saved");

	}

}
