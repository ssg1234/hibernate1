package com.hexa.demos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Student;

public class WhereDemo {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory sfac = cfg.buildSessionFactory();
		Session sess = sfac.openSession();
		//String hql = "from Student";    only used to select rows from a table
		
	    String hql ="from Student where dept=?";	
		Query qry = sess.createQuery(hql);
		qry.setString(0, "ece");
		List<Student> lst = qry.list();
		sess.close();
		lst.stream().forEach(System.out::println);


	}

}
