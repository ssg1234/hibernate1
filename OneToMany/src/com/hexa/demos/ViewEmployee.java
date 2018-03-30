package com.hexa.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Emp;

public class ViewEmployee {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory sfac = cfg.buildSessionFactory();
		Session sess =sfac.openSession();
		Emp emp=(Emp)sess.get(Emp.class, 1003);
		sess.close();
		System.out.println(emp.getEmpId() + " " +emp.getEmpName() + " " + emp.getSal() 
		+ " " +emp.getDept().getDeptName());
	}

}
