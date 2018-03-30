package com.hexa.demos;

import com.hexa.dao.DaoImpl;
import com.hexa.dao.IDao;
import com.hexa.entity.Student;

public class ViewEmployee {

	public static void main(String[] args) {
		IDao dao = new DaoImpl();
		Student stu = dao.getStudent(1002);
		if(stu!= null) {
			System.out.println(stu);
		} else 
			System.out.println("not found");

	}

}
