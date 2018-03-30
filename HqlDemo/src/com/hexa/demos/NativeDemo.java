package com.hexa.demos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.entity.Student;

public class NativeDemo {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory sfac = cfg.buildSessionFactory();
		Session sess = sfac.openSession();
	    String sql ="select stu_id, stu_name,stu_marks from student";
	    Query qry = sess.createSQLQuery(sql);
	    List<Object[]> lst = qry.list();
	    sess.close();
	    lst.forEach(arr->{System.out.println(arr[0]);
	    					System.out.println(arr[1]);
	    					System.out.println(arr[2]);
	    					System.out.println("------------------------");
	    });
	
	}

}
