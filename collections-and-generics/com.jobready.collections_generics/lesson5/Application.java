package lesson5;

import java.util.HashMap;
import java.util.Map;

public class Application {

	public static void main(String[] args) {

		// A HashMap is kind of like a dictionary, every row of data in it
		// includes a key, and a value, kind of like a dictionary has a
		// word (key) and its definition (value).
		// Implements the map interface, does not come from Collections,
		// it is not a list, however like a List, we cannot put in
		// primitive data types, and like a Set, a HashMap has no order.
		HashMap<String, String> dictionary = new HashMap<String, String>();

		// LinkedHashMap does preserve data insertion order.

		// To add entries to a HashMap we use .put()
		dictionary.put("Brave", "ready to face and endure danger or pain");
		dictionary.put("Brilliant", "exceptionally clever or talented");
		dictionary.put("Joy", "a feeling of great pleasure and happiness");
		dictionary.put("Confidence", "the state of feeling certain about...");
		
		//A Map (dictionary) cannot be used to store duplicates, if I do:
		dictionary.put("Brilliant", "xxxxxxxxxxx");
		//This is the value that the "Brilliant" key will have and
		//it will lose its previous one

		// Unlike lists where just the name of the list is needed,
		// to iterate over a HashMap we need the .keySet() method
		// if we want to iterate over the keys and the .values()
		// method if we want to iterate over the values

		// Iterates over the entries' keys
		for (String word : dictionary.keySet()) {
			// Prints out the "key" part of the data
			System.out.println(word);
		}

		// Iterates over the entries' values
		for (String word : dictionary.values()) {
			// Prints out the "value" part of the data
			System.out.println(word);
		}

		//Iterates over both the entries' keys and values
		for (Map.Entry<String, String> var : dictionary.entrySet()) {
			System.out.println(var.getKey() + ": " + var.getValue());
		}
	}

}
