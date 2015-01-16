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

		String minUserID = "5";
		String userName = "User 8";
		
		//Query query = session.createQuery("from UserDetails where userId > ? and userName = ?");
		Query query = session.createQuery("from UserDetails where userId > :minUserID and userName = :userName");
		/*query.setInteger(0, Integer.parseInt(minUserID));
		query.setString(1, userName);*/
		
		query.setInteger("minUserID", Integer.parseInt(minUserID));
		query.setString("userName", userName);
		
		List<UserDetails> user = (List<UserDetails>)query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for (UserDetails u : user){
			System.out.println(u.getUserName());
		}
	}
}
