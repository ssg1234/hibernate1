package com.hexa.demos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hexa.entity.Student;

public class ProjectionDemo {
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
    	plist.add(Projections.property("stuId"));
    	plist.add(Projections.property("stuName"));
    	plist.add(Projections.property("marks"));
  
    	crit.setProjection(plist);
    	
    	List<Object[]> lst= crit.list();
    	
    	sess.close();
    	lst.forEach(arr->{System.out.println(arr[0]);
    					System.out.println(arr[1]);
    					System.out.println(arr[2]);
    	});
	}

}
