package com.hexa.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Contract;
import com.hexa.entity.Onroll;

public class Demo1 {

	
		private static SessionFactory sfac;
	    static {
	    	Configuration cfg = new AnnotationConfiguration();
			cfg.configure();
		    sfac = cfg.buildSessionFactory();
	    }
	    public static void main(String[] args) {
	    	//System.out.println("table created");
	    	Session sess = sfac.openSession();
	    	Transaction tx = sess.beginTransaction();
	    	Onroll obj = new Onroll();
	    	obj.setEid(1001);
	    	obj.setEname("raja");
	    	obj.setSal(45000);
	    	obj.setBonus(5000);
	    	
	    	Contract obj2 = new Contract();
	    	obj2.setEid(1002);
	    	obj2.setEname("bala");
	    	obj2.setSal(23000);
	    	obj2.setDays(5);
	    	
	    	sess.save(obj);
	    	sess.save(obj2);
	    	
	    	tx.commit();
	    	sess.close();
	    	System.out.println("row inserted");
	}

}
