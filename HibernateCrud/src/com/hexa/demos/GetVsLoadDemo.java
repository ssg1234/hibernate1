package com.hexa.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Student;

public class GetVsLoadDemo {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory sfac = cfg.buildSessionFactory();
		Session sess =sfac.openSession();
		Student stu = (Student)sess.load(Student.class, 100);
		//Student stu = (Student)sess.get(Student.class, 100);
		if(stu!= null) {
			System.out.println(stu);
		} else {
			System.out.println("not found");
		}
		sess.close();
		
	}
}
