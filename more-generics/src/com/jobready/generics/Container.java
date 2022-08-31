package com.jobready.generics;

public class Container<i1, i2> {

	i1 item1;
	i2 item2;

	//Making the class generic, i1 and i2 are generic types, not String, double,
	//int, a user-defined class, etc.  They mean nothing, and can accept anything
	//as long as we specify the type of what we are passing in.
	//Generics help keep the promise of developer flexibility without sacrificing
	//the benefits of type-safety at compile time by still having to specify types
	public Container(i1 item1, i2 item2) {
		super();
		this.item1 = item1;
		this.item2 = item2;
	}

	public void printItems() {
		System.out.println("Printing contents of container");
		System.out.println("Item 1: " + item1);
		System.out.println("Item 2: " + item2);
	}

	public i1 getItem1() {
		return item1;
	}

	public void setItem1(i1 item1) {
		this.item1 = item1;
	}

	public i2 getItem2() {
		return item2;
	}

	public void setItem2(i2 item2) {
		this.item2 = item2;
	}

}
