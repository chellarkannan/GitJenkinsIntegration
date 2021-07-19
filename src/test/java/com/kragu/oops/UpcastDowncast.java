package com.kragu.oops;

class SuperClass {

	public void super_action() {
		System.out.println("Super-Action");
	}

	public void super_print() {
		System.out.println("Super-Print");
	}
}

class SubClass extends SuperClass {

	public void sub_action() {
		System.out.println("Sub-Action");
	}

	public void sub_print() {
		System.out.println("Sub-Print");
	}

	/*
	 * @Override public void super_print() {
	 * System.out.println("Overriden Super Class Method"); }
	 */
}

public class UpcastDowncast {
	public static void main(String args[]) {
		/*
		 * Up casting - sub class object referred by super class reference Though it is
		 * a sub class reference, through this object reference sub class methods cannot
		 * be accessed. Upcast restricts accessing visibility of methods of downwards
		 */
		SuperClass sup = new SubClass();
		sup.super_action();
		sup.super_print(); // If super class method is overridden in sub class, then that can be accessed
							// with out downcasting

		/*
		 * Downcasting - to access sub class methods, super class reference needs to be
		 * downcast to a upcast reference only.
		 */
		SubClass sub = (SubClass) sup;
		sub.super_action();
		sub.super_print();
		sub.sub_action();
		sub.sub_print();

		// sup - upcast reference
		// sub - downcast reference
	}
}
