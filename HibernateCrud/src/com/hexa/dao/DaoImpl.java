package com.hexa.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Student;

public class DaoImpl implements IDao {
	private static SessionFactory sfac;
	static {
		Configuration cfg=new AnnotationConfiguration().configure();
		sfac = cfg.buildSessionFactory();
	}
	@Override
	public int addStudent(Student stu)
	{
		Session sess= null;
		Transaction tx= null;
	try {
		sess= sfac.openSession();
		tx = sess.beginTransaction();
		sess.save(stu);
		tx.commit();
		return 1;
		
	}catch(HibernateException ex) {
		System.out.println(ex.getMessage());
		if(tx!= null)
			tx.rollback();
		
	}finally {
		if(sess!= null) 
			sess.close();
	 }
	return 0;
 }
	@Override
	public Student getStudent(int sid) {
		Session sess=sfac.openSession();
		Student stu =(Student)sess.get(Student.class,sid);
		sess.close();
		return stu;
	}
	@Override
	public int updateStudent(int sid, int marks) {
		Session sess =sfac.openSession();
		Student stu =(Student)sess.get(Student.class, sid);
		Transaction tx = sess.beginTransaction();
		stu.setMarks(marks);
		tx.commit();
		sess.close();
		return 1;
	}
	@Override
	public int deleteStudent(int sid) {
		Session sess =sfac.openSession();
		Student stu =(Student)sess.get(Student.class, sid);
		Transaction tx =sess.beginTransaction();
		try {
			sess.delete(stu);
			tx.commit();
			return 1;
			
		} catch(HibernateException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(stu);
		sess.close();
		return 0;
	}
	@Override
	public int updateStudent(Student stu) {
		Session sess = sfac.openSession();
		Transaction tx =sess.beginTransaction();
		try {
		sess.saveOrUpdate(stu);
	    tx.commit();
	    return 1;
		}catch(HibernateException ex) {
			System.out.println(ex.getMessage());
		}
	    sess.close();
	    return 0;
	
	}
	
}
