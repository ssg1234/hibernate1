package com.hexa.demos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Student;

public class BetweenDemo {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory sfac = cfg.buildSessionFactory();
		Session sess = sfac.openSession();
		/*named parameters
	    String hql ="from Student where marks between :minmarks and :maxmarks";	
		Query qry = sess.createQuery(hql);
		qry.setInteger("minmarks",60);
		qry.setInteger("maxmarks",80);*/
		
		String hql ="from Student where marks between ? and ?";	
		Query qry = sess.createQuery(hql);
		qry.setInteger(0,60);
		qry.setInteger(1,80);
		List<Student> lst = qry.list();
		sess.close();
		lst.stream().forEach(System.out::println);


	}

}
