package com.hexa.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Dept;
import com.hexa.entity.Emp;

public class InsertEmployee {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory sfac = cfg.buildSessionFactory();
        //System.out.println("table created...");
		Session sess = sfac.openSession();
		Transaction tx = sess.beginTransaction();
		
		Dept dept = new Dept();
		dept.setDeptId(2);
		
		Emp emp = new Emp();
		emp.setEmpId(1005);
		emp.setEmpName("peter");
		emp.setSal(43000);
		emp.setPwd("peter123");
		emp.setImg("1005.jpg");
		emp.setDept(dept); //stores the foreign key
		
		sess.save(emp);
		
		tx.commit();
		sess.close();
		System.out.println("Row Inserted");
		
	}

}
