package org.julia.hibernate;

import java.nio.channels.SeekableByteChannel;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.julia.javabrains.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails exampleUser = new UserDetails();
		//exampleUser.setUserId(5);
		exampleUser.setUserName("User 1%");
		
		Example example = Example.create(exampleUser).enableLike();

		Criteria criteria = session.createCriteria(UserDetails.class)
				.add(example);

		List<UserDetails> user = (List<UserDetails>) criteria.list();

		session.getTransaction().commit();
		session.close();

		for (UserDetails u : user) {
			System.out.println(u.getUserName());
		}
	}
}
