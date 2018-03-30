package com;
interface Abc{
	void dis1();
}
class Work implements Abc{
	public void dis1()
{
		System.out.println("Method implementation");
}
}
class Demo1{
	public static void ownMethod() {
		System.out.println("Demo1 class implementation-static method");
	}
	public void anotherMethod() {
		System.out.println("Demo1 class implementation-non static method");
	}
}

public class MethodRefDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println("First way using corejava");
		Abc obj= new Demo();
		obj.dis1();
		
		System.out.println("Second way using lambda expression");*/
		
		System.out.println("third way using method reference");
		Abc obj1=Demo1::ownMethod;
		obj1.dis1();
		
		Demo1 ref=new Demo1();
		Abc obj3=ref::anotherMethod;
		obj3.dis1();
		
	}

}
