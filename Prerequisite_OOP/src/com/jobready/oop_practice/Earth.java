package com.jobready.oop_practice;

public class Earth {

	public static void main(String[] args) {
		
		//Human tom;
		//tom = new Human();
		
		//tom.name = "Tom Zsabo";
		//tom.heightInInches = 78;
		//tom.age = 34;
		//tom.eyeColor = "brown";
		
		//tom.speak();
		
		//Another way to create a human
		//Human joe = new Human();
		
		//joe.name = "Joe Greensilk";
		//joe.heightInInches = 66;
		//joe.age = 45;
		//joe.eyeColor = "green";
		
		//joe.speak();
		
		Human human1 = new Human("Tom", 25, 76, "blue");
		Human human2 = new Human("Joe", 55, 57, "green");
		
		human1.speak();
		human2.speak();
	}
}
