package com.kragu.oops;

public class MultilevelInheritance {

	public static void main(String args[]) {
	B b = new B();
	}
}

class A {
	
	A(){
		System.out.println("Constructor - A");
	}
}

class B extends A {
	B(){
		System.out.println("Constructor - B");
	}
}