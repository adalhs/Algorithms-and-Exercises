package com.jobready.oop_practice;

public abstract class Animal {

	int age;
	int weightInPounds;
	int heightInInches;
	String species;
	
	public Animal(int age, int weightInPounds, int heightInInches, String species) {
		super();
		this.age = age;
		this.weightInPounds = weightInPounds;
		this.heightInInches = heightInInches;
		this.species = species;
	}
	
	public void eat() {
		System.out.println("I am a " + age + " year old " + species + ".  I weigh " + weightInPounds + " pounds, I'm " + heightInInches + " inches tall, and I'm eating.");
	}
	
	public void walk() {
		System.out.println("I am a " + age + " year old " + species + ".  I weigh " + weightInPounds + " pounds, I'm " + heightInInches + " inches tall, and I'm walking.");
	}
	
	public void sleep() {
		System.out.println("Sleeping...");
	}
	
	public abstract void move();
}
