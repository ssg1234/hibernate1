package com.hexa.demos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.hexa.entity.Student;

public class BetweenDemo {
	private static SessionFactory sfac;
    static {
    	Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
	    sfac = cfg.buildSessionFactory();
    }
	public static void main(String[] args) {
		Session sess =sfac.openSession();
    	Criteria crit = sess.createCriteria(Student.class);
    	//Criterion c1 = Restrictions.ge("marks", 60);
    	//Criterion c2 = Restrictions.le("marks", 80);
    	Criterion c1 = Restrictions.between("marks", 60, 80);
    	crit.add(c1);
    	//crit.add(c2);
    	List<Student> lst= crit.list();
    	sess.close();
    	lst.forEach(System.out::println);
	}

}
