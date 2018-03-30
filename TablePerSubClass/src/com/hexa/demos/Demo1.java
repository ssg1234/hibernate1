package com.hexa.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Contact;

public class Demo1 {
	private static SessionFactory sfac;
    static {
    	Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
	    sfac =cfg.buildSessionFactory();
    }
	public static void main(String[] args) {
	
		//System.out.println("table created");
		Session sess= sfac.openSession();
		Transaction tx = sess.beginTransaction();
		Contact con =(Contact)sess.get(Contact.class,1);
		System.out.println("Email:" +con.getEmail() + "Uid:" +con.getUid());
        sess.close();
	}

}
