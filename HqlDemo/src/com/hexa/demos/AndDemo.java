package com.hexa.demos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Student;

public class AndDemo {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory sfac = cfg.buildSessionFactory();
		Session sess = sfac.openSession();
	    String hql ="from Student where marks>=? and dept=?";	
		Query qry = sess.createQuery(hql);
		qry.setInteger(0,95);
		qry.setString(1,"ece");
		List<Student> lst = qry.list();
		sess.close();
		lst.stream().forEach(System.out::println);


	}

}
