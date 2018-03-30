package com.hexa.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Student;

public class DetachedDemo {
	private static SessionFactory sfac;
	
	static {
		Configuration cfg=new AnnotationConfiguration().configure();
		sfac = cfg.buildSessionFactory();
	}
	public static void main(String[] args) {
		Student stu = getStudent(1002);
		Session sess = sfac.openSession();
		Transaction tx = sess.beginTransaction();
		stu.setMarks(87);
		sess.saveOrUpdate(stu);
		tx.commit();
		sess.close();
		System.out.println("done");
	}
	public static Student getStudent(int sid) {
		Session sess = sfac.openSession();
		Student stu = (Student)sess.get(Student.class, sid);
		sess.close();
		return stu;
	}

}
