package org.julia.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.julia.javabrains.dto.Address;
import org.julia.javabrains.dto.FourWheeler;
import org.julia.javabrains.dto.TwoWheeler;
import org.julia.javabrains.dto.UserDetails;
import org.julia.javabrains.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");

	FourWheeler car = new FourWheeler();
	car.setVehicleName("Porsche");
	car.setSteeringWheel("Porsche Steering Wheel");

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		session.getTransaction().commit();
		session.close();

	}
}
