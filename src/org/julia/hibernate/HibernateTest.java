package org.julia.hibernate;

import java.nio.channels.SeekableByteChannel;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.julia.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);

		session.getTransaction().commit();
		session.close();

		user.setUserName("Changed name");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		
		session.getTransaction().commit();
		session.close();
	}
}
