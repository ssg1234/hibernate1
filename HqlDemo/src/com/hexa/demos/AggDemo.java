package com.hexa.demos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Student;

public class AggDemo {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory sfac = cfg.buildSessionFactory();
		Session sess = sfac.openSession();
	    String hql ="select sum(marks),avg(marks),max(marks),min(marks) from Student";	
		Query qry = sess.createQuery(hql);
		Object[] arr = (Object[])qry.uniqueResult();
		sess.close();
		System.out.println("total marks=" +arr[0]);
		System.out.println("avg marks=" +arr[1]);
		System.out.println("max marks=" +arr[2]);
		System.out.println("min marks=" +arr[3]);
	}

}
