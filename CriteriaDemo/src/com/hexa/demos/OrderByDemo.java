package com.hexa.demos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;

import com.hexa.entity.Student;

public class OrderByDemo {
		private static SessionFactory sfac;
	    static {
	    	Configuration cfg = new AnnotationConfiguration();
			cfg.configure();
		    sfac = cfg.buildSessionFactory();
	    }
	    public static void main(String[] args) { 
	    	Session sess =sfac.openSession();
	    	Criteria crit = sess.createCriteria(Student.class);
	    	Order ord = Order.desc("marks");
	    	crit.addOrder(ord);
	    	List<Student> lst= crit.list();
	    	sess.close();
	    	lst.forEach(System.out::println);
	    	
	}

}
