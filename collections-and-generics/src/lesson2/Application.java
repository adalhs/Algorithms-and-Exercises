package lesson2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		List<String> animals = new ArrayList<String>();
		animals.add("Lion");
		animals.add("Cat");
		animals.add("Dog");
		animals.add("Bird");

		for(int i = 0; i < animals.size(); i++) {
			System.out.println(animals.get(i));
		}
		
		//Simpler For Each loop available from Java 5 onward
		for(String animal : animals) {
			System.out.println(animal);
		}
		
		//I can also use classes I have created as the type of data
		List<Vehicle> vehicles = new LinkedList<Vehicle>();
		
		//First way to initialize the object.  Here I am specifying a
		//variable that I can use to refer to the object.
		Vehicle vehicle1 = new Vehicle("Toyota", "Camry", 12000, false);
		vehicles.add(vehicle1);
		
		//Second way, here I am doing it in-line, and not specifying
		//a variable I can use to refer to the object.
		vehicles.add(new Vehicle("Honda", "Accord", 12000, false));
		vehicles.add(new Vehicle("Jeep", "Wrangler", 25000, true));
		
		for(Vehicle car : vehicles){
			System.out.println(car.toString());
		}
		
		printElements(animals);
		printElements(vehicles);
	}
	
	public static void printElements(List someList) {
		for(int i = 0; i < someList.size(); i++) {
			System.out.println(someList.get(i));
		}
	}

}
