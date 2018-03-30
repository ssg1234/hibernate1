package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreamCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> lt =new ArrayList<>(); //1.7
		
		//List<Employee> listofEmp = new ArrayList<Employee>();//1.6
		lt.add(new Employee(1, "Raj",13000));
		lt.add(new Employee(3, "RajDeep",15000));
		lt.add(new Employee(2, "Geeta",18000));
		lt.add(new Employee(4, "Seeta",13000));
		float sum=0;
		System.out.println("Using iterator");
		Iterator<Employee> li=lt.iterator();
		while(li.hasNext()) {
			Employee emp =li.next();
			sum =sum +emp.getSalary();
		}
		System.out.println("sum of salary of all employees="+sum);
		System.out.println("Using Stream");
		//lt.stream().forEach((emp)->System.out.println(emp));
		//double sumOfStream=lt.stream().filter((emp)->emp.getSalary()>0).mapToDouble((emp)->emp.getSalary()).sum();
		//double sumOfStream=lt.stream().mapToDouble((emp)->emp.getSalary()).sum();
		double sumOfStream=lt.stream().filter(emp->emp.getSalary()>0).mapToDouble(emp->emp.getSalary()).max().getAsDouble();
		//System.out.println("Sum of salary of all employees="+sumOfStream);
		//forEach(sal->System.out.println(sal));
		System.out.println(sumOfStream);
	}

}
