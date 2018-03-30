package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome");
		Employee emp1=new Employee(1,"Raj",12000);
		Employee emp2=new Employee(2,"Seeta",15000);
		Employee emp3=new Employee(3,"RajDeep",18000);
		List<Employee> listOfEmp = new ArrayList<Employee>();
		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);
		listOfEmp.forEach((emp)->System.out.println(emp));
		Collections.sort(listOfEmp);
		listOfEmp.forEach((emp)->System.out.println(emp));
	}

}
