package com.hexa.demos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.hexa.dao.DaoImpl;
import com.hexa.dao.IDao;
import com.hexa.entity.Student;

public class InsertEmployee {
	private static IDao dao = new DaoImpl();
	public static void main(String[] args) throws ParseException {
		Student stu = new Student();
		stu.setStuId(1004);
		stu.setStuName("Akshata");
		stu.setMarks(95);
		stu.setDept("ece");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dt =sdf.parse("19/12/1995");
		stu.setDob(dt);
		int res = dao.addStudent(stu);
		System.out.println("inserted :" + res + " rows");	
	}

}
