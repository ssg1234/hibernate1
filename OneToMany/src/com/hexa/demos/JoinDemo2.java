package com.hexa.demos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Emp;

public class JoinDemo2 {

		private static SessionFactory sfac;
	    static {
	    	Configuration cfg = new AnnotationConfiguration();
			cfg.configure();
		    sfac = cfg.buildSessionFactory();
	    }
		public static void main(String[] args) {
			Session sess = sfac.openSession();
			String hql = "from Emp e inner join fetch e.dept where e.empId =?";
			Query qry = sess.createQuery(hql);
			qry.setInteger(0, 1002);
			Emp emp=(Emp)qry.uniqueResult();
			sess.close();
		
			System.out.println(emp.getEmpId() + " " + emp.getEmpName() + " " + emp.getSal() 
				+ " " + emp.getDept().getDeptName());
			

	}

}
