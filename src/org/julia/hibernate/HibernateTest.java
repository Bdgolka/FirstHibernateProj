package org.julia.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.julia.javabrains.dto.Address;
import org.julia.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Julia");

		Address addr1 = new Address();
		addr1.setStreet("Razumovskaya");
		addr1.setCity("Odessa");
		addr1.setState("Odessa");
		addr1.setPincode("65000");

		Address addr2 = new Address();
		addr2.setStreet("Gromova");
		addr2.setCity("Kiev");
		addr2.setState("Kiev");
		addr2.setPincode("61000");

		user.getListofAddresses().add(addr1);
		user.getListofAddresses().add(addr2);

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();

		// fetch the object
		user = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getListofAddresses().size());

	}
}
