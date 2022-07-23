package lesson4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		
		HashSet<Integer> hashSet1 = new HashSet<Integer>();
		hashSet1.add(12);
		hashSet1.add(43);
		hashSet1.add(15);
		hashSet1.add(67);
		hashSet1.add(43);
		hashSet1.add(10);
		
		ArrayList<Integer> myList = new ArrayList<Integer>(hashSet1);
		
		//Sorts a collection
		Collections.sort(myList);
		System.out.println(myList);
		
		
		//Explanation on sorting a list of objects on Java Note 37
		HashSet<Employee> hashSet2 = new HashSet<Employee>();
		hashSet2.add(new Employee("Mike", 3500, "Accounting"));
		hashSet2.add(new Employee("Paul", 3000, "Admin"));
		hashSet2.add(new Employee("Peter", 4000, "IT"));
		hashSet2.add(new Employee("Angel", 2000, "Maintenance"));
		
		ArrayList<Employee> myList2 = new ArrayList<Employee>(hashSet2);
		
		Collections.sort(myList2);
		System.out.println(myList2.toString());
		
//		List<Integer> li = new ArrayList<Integer>(list1);
//		
//		ArrayList<Integer> newList = new ArrayList<Integer>();
//		newList.add(10);
//		newList.add(67);
//		newList.add(15);
//		
//		//Adds all values in newList to list1
//		//list1.addAll(newList);
//		
//		//Clears all values from list1
//		//list1.clear()
//		
//		//Check for specific value inside a list
//		boolean hasValue = list1.contains(10);
//		System.out.println(hasValue);
//		
//		//Check if list is empty
//		boolean var = list1.isEmpty();
//		System.out.println(var);
//		
//		//Removes all values in newList from list1
//		//list1.removeAll(newList);
//		//System.out.println(list1);
//		
//		//Deletes everything in the list except the values in the
//		//list passed in
//		list1.retainAll(newList);
//		System.out.println(list1);

	}

}
