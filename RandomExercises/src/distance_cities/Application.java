package distance_cities;

import java.util.Map;
import java.util.TreeMap;

public class Application {

	public static void main(String[] args) {
		//You want to do a roadtrip, and you want to visit 5 cities.  You are trying to find the distance between each city and the order you should visit
		//them, but you are only given the names of the cities and the distance from your starting point.  Figure out the distance between the cities, and the
		//best way to visit them.
		
		//String containing cities and their distance from your starting point
		String cities = "Sandoria, 4321; Windurst, 174; Jeuno, 823; Bastok, 7899; Yhoator, 3466;";
		
		
		//Start here...
		//Splits "cities" string after every ";" making 5 elements, and enters the newly separated elements into String array "myArray"
		String[] myArray = cities.split(";");
		
		//Will hold distance from city and city name as (key, value) in this TreeMap.  The TreeMap is a Map (like HashMap), but it is ordered.
		TreeMap<Integer, String> myMap = new TreeMap<>();
		
		//Iterating through the elements in "myArray"
		for(int i = 0; i < myArray.length; i++) {
			String cityName = "";
			String distanceFromStart = "";
			
			//Iterating through every character in every element in "myArray". Notice the use of .length() because I am looking through a String instead of
			//.length above where I am looking through an array's elements
			for(int j = 0; j < myArray[i].length(); j++) {
				
				//If character in the string is a letter, will add it to the "cityName" string.  Will ignore commas, numbers, and semicolon
				if (Character.isLetter(myArray[i].charAt(j))){
					cityName += myArray[i].charAt(j);
					
					//If character in the string is a digit, will add it to the "distanceFromStart" string.  Will ignore commas, letters, and semicolon
				} else if (Character.isDigit(myArray[i].charAt(j))){
					distanceFromStart += myArray[i].charAt(j);
				}
			}
			
			//Assigning distanceFromStart (converted from String to int) as entry key and cityName as entry value to "myMap" TreeMap
			myMap.put(Integer.parseInt(distanceFromStart), cityName);
		}
		
		//Calling .calculator() method of DistanceCalculator Class.  I do not have to instantiate a DistanceCalculator object, because the .calculator()
		//method is static (can be used by the class itself but not by an object of the class type)
		DistanceCalculator.calculator(myMap);
	}

}
