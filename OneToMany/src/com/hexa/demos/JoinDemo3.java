package com.hexa.demos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Emp;

public class JoinDemo3 {
		private static SessionFactory sfac;
	    static {
	    	Configuration cfg = new AnnotationConfiguration();
			cfg.configure();
		    sfac = cfg.buildSessionFactory();
	    }
		public static void main(String[] args) {
			Session sess = sfac.openSession();
			String hql = "from Emp e inner join fetch e.dept d where d.deptName = ?";
			Query qry = sess.createQuery(hql);
			qry.setString(0, "production");
			List<Emp> lst= qry.list();
			
			sess.close();
			for(Emp emp:lst) {
			System.out.println(emp.getEmpId() + " " + emp.getEmpName() + " " + emp.getSal() 
				+ " " + emp.getDept().getDeptName());
			}

	}

	}


