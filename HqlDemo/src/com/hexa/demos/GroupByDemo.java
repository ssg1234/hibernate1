package com.hexa.demos;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class GroupByDemo {

	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure();
		SessionFactory sfac = cfg.buildSessionFactory();
		Session sess = sfac.openSession();
	    String hql ="select dept,avg(marks),max(marks),min(marks) from Student group by dept";	
		Query qry = sess.createQuery(hql);
		List<Object[]> lst = qry.list();
		sess.close();
		lst.stream().forEach(arr->{System.out.println(arr[0]);
        							System.out.println(arr[1]);
        							System.out.println(arr[2]);
        							System.out.println(arr[3]);
});
	}

}
