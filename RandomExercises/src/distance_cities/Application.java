package distance_cities;

import java.util.TreeMap;

public class Application {

	public static void main(String[] args) {
		// You want to do a roadtrip, and you want to visit 5 cities. You are trying to
		// find the distance between each city and the order you should visit
		// them, but you are only given the names of the cities and the distance from
		// your starting point. Figure out the distance between the cities, and the
		// best way to visit them.

		// String containing cities and their distance from your starting point
		String cities = "Sandoria, 4321; Windurst, 174; Jeuno, 823; Bastok, 7899; Yhoator, 3466;";

		// Start here...
		String city = ""; // will accumulate the characters of the city names in the string
		String dist = ""; // will accumulate the digits of the city distances in the string

		// Will hold distance from city and city name as (key, value) in this TreeMap.
		// The TreeMap is a Map (like HashMap), but it is ordered.
		TreeMap<Integer, String> myMap = new TreeMap<>();

		//Iterating through every letter in the string and saving city names/distances in map
		//I am putting the distances as the keys and the names as the vaues because TreeMaps sort through the key values
		//and this will make the subtraction of the next city's distance from the previous city's distance easier
		for (int i = 0; i < cities.length(); i++) {
			if (Character.isLetter(cities.charAt(i))) {
				city += cities.charAt(i);
			} else if (Character.isDigit(cities.charAt(i))) {
				dist += cities.charAt(i);
			} else if (cities.charAt(i) == ';') {
				myMap.put(Integer.parseInt(dist), city);
				city = "";
				dist = "";
			}
		}
		// Calling .calculator() method of DistanceCalculator Class. I do not have to
		// instantiate a DistanceCalculator object, because the .calculator()
		// method is static (can be used by the class itself but not by an object of the
		// class type)
		DistanceCalculator.calculator(myMap);

	}

}