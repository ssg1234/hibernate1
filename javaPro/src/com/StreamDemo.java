package com;

import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String args[]) {
		Integer abc[]= {1,6,7,8,5,4,3,3,4,6,8,9};
		Stream<Integer> st= Stream.of(abc);
		//st.sorted().forEach((val)->System.out.println(val));
		System.out.println("Number of elements: "+st.count());
	}

}
