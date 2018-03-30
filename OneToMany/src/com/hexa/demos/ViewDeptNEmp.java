package com.hexa.demos;

import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Dept;
import com.hexa.entity.Emp;

public class ViewDeptNEmp {
	private static SessionFactory sfac;
	static {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		sfac = cfg.buildSessionFactory();
	}
	public static void main(String[] args) {
		
		//Session sess = sfac.openSession();
		//Dept dept = (Dept)sess.get(Dept.class, 1);
		Dept dept = getDept(1);
		System.out.println(dept.getDeptId() + " " + dept.getDeptName());
        System.out.println("----------------------------");
        Set<Emp> set =dept.getElist();
        for(Emp emp: set ) {
        	System.out.println(emp.getEmpId() + " " +emp.getEmpName() + " " + emp.getSal());
        }
	    //sess.close();
	}
   public static Dept getDept(int id) {
	 Session sess =sfac.openSession();
	 Dept dept = (Dept)sess.get(Dept.class,id);
	 Hibernate.initialize(dept.getElist()); //demanding child instances
	 sess.close();
	 return dept;
	 
   }
}
