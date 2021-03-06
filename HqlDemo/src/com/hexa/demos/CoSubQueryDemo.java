package com.hexa.demos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CoSubQueryDemo {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory sfac = cfg.buildSessionFactory();
		Session sess = sfac.openSession();
	    String hql ="from Student s1 where marks= (select max(marks) from Student where dept = s1.dept)";	
		Query qry = sess.createQuery(hql);
		List<Object> lst = qry.list();
		sess.close();
		lst.stream().forEach(System.out::println);
				
	}

	}


