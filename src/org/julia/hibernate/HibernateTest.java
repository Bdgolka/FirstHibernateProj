package org.julia.hibernate;

import java.nio.channels.SeekableByteChannel;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
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

		Query query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "User 8");

		List<UserDetails> user = (List<UserDetails>) query.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails u : user) {
			System.out.println(u.getUserName());
		}
	}
}
