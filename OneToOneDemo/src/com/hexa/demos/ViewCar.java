package com.hexa.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Car;

public class ViewCar {
		private static SessionFactory sfac;
	    static {
	    	Configuration cfg = new AnnotationConfiguration();
			cfg.configure();
		    sfac = cfg.buildSessionFactory();
	    }
		public static void main(String[] args) {
			//System.out.println("table created");
			Session sess = sfac.openSession();
			Car car = (Car)sess.get(Car.class, 1);
			sess.close();
			System.out.println(car.getCarId() + " " +car.getCarName() + " " + car.getPrice() );
			System.out.println(car.getChasis().getChasisId() + " " +car.getChasis().getChasisType());
		}

}
