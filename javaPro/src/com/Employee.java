package com;
public class Employee implements Comparable<Employee>{
public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
public Employee(int id, String name, float salary) {
	super();
	this.id = id;
	this.name = name;
	this.salary = salary;
}
private int id;
private String name;
private float salary;
public int compareTo(Employee emp){
	return (int)(emp.salary-this.salary); //sort salary by asc
	//return id-this.id; //sort by desc order
	//return this.id-id; //sort by asc 
	//return this.name.compareTo(emp.name);//sort name by asc
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}


@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
}

}
