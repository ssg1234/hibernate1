package com.hexa.demos;

import com.hexa.dao.DaoImpl;
import com.hexa.dao.IDao;
import com.hexa.entity.Student;

public class UpdateMarks2 {

	public static void main(String[] args) {
		IDao dao = new DaoImpl();
		Student stu = dao.getStudent(1002);
		stu.setMarks(97);
		dao.updateStudent(stu);
		System.out.println("updated");

	}

}
