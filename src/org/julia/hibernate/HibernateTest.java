package org.julia.hibernate;

import java.nio.channels.SeekableByteChannel;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.julia.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Test user");
		
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user);

		user.setUserName("Updated user");
		
		session.getTransaction().commit();
		session.close();

	}
}
