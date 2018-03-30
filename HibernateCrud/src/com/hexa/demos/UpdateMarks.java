package com.hexa.demos;

import com.hexa.dao.DaoImpl;
import com.hexa.dao.IDao;

public class UpdateMarks {

	public static void main(String[] args) {
		IDao dao = new DaoImpl();
		int res = dao.updateStudent(1002, 78);
		System.out.println("updated");
	}

}
