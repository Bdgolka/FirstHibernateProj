package org.julia.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.julia.javabrains.dto.Address;
import org.julia.javabrains.dto.UserDetails;
import org.julia.javabrains.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Julia");

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
	
		session.getTransaction().commit();
		session.close();

	}
}
