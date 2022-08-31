package com.jobready.oop_practice;
public class Chicken extends Bird{

	public Chicken(int age, int weightInPounds, int heightInInches, String species) {
		super(age, weightInPounds, heightInInches, species);
		// TODO Auto-generated constructor stub
	}

	//The Chicken class extends from the Bird class, and even though the Bird class
	//has a fly method in it, the method prints to the console "flying...".  Even though
	//a Chicken is a Bird, Chickens cannot fly, so in this case I can OVERRIDE the "fly" method
	//in Bird, by declaring a "fly" method in Chicken.  When I call chick1.fly(); in the Zoo
	//class, it will show this fly method, not the one in Bird.
	//public void fly() {
		//System.out.println("Unable to fly...");
	//}
}
