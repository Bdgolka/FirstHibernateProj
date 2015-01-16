package org.julia.hibernate;

import java.nio.channels.SeekableByteChannel;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.julia.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Criteria criteria = session.createCriteria(UserDetails.class); // choose the entity
		criteria.add(Restrictions.or(Restrictions.between("userId", 0, 3), Restrictions.between("userId", 6, 9)));

		List<UserDetails> user = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails u : user) {
			System.out.println(u.getUserName());
		}
	}
}
