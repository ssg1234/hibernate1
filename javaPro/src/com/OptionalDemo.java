package com;

import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp[]=new Employee[10];
		emp[0]=new Employee();
		emp[3]=new Employee();
		//System.out.println("id="+emp[3].getId());
		Optional<Employee> obj = Optional.ofNullable(emp[3]);
		if(obj.isPresent()) {
			System.out.println("Id is"+emp[0].getId());
		} else {
			System.out.println("Memory not created");
		}
	}

}
