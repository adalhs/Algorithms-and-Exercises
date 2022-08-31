package com.jobready.oop_practice;
public class Bird extends Animal{

	public Bird(int age, int weightInPounds, int heightInInches, String species) {
		super(age, weightInPounds, heightInInches, species);
		// TODO Auto-generated constructor stub
	}

	public void move() {
		System.out.println("Bird is flapping wings...");
	}
	
	//public void fly() {
		//System.out.println("flying...");
	//}

}
