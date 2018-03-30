package com.hexa.demos;

import com.hexa.dao.DaoImpl;
import com.hexa.dao.IDao;

public class DeleteStudent {

	public static void main(String[] args) {
		IDao dao = new DaoImpl();
		int res = dao.deleteStudent(1001);
		System.out.println("deleted");

	}

}
