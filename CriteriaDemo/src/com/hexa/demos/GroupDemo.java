package com.hexa.demos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.hexa.entity.Student;

public class GroupDemo {
	private static SessionFactory sfac;
    static {
    	Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
	    sfac = cfg.buildSessionFactory();
    }
	public static void main(String[] args) {
		Session sess =sfac.openSession();
    	Criteria crit = sess.createCriteria(Student.class);
    	
    	ProjectionList plist = Projections.projectionList();
    	plist.add(Projections.min("marks"));
    	plist.add(Projections.avg("marks"));
    	plist.add(Projections.max("marks"));
    	plist.add(Projections.groupProperty("dept"));
    	crit.setProjection(plist);
    	
    	List<Objec t[]> lst= crit.list();
    	
    	sess.close();
    	lst.forEach(arr->{System.out.println(arr[0]);
    					System.out.println(arr[1]);
    					System.out.println(arr[2]);
    	});
	}

}
