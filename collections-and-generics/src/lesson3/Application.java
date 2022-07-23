package lesson3;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Application {

	public static void main(String[] args) {
		
		//Sets are similar to ArrayLists except that they do not
		//accept duplicate values in them.
		HashSet<Integer> numbers = new HashSet<Integer>();
		numbers.add(12);
		numbers.add(43);
		numbers.add(15);
		numbers.add(67);
		numbers.add(43);
		
		//Notice the duplicated 43 will not be printed as it is not
		//added to the set because it is already in it.  Also notice
		//that unlike Arrays, a Set doesn't keep the same order that
		//the values are entered into it.
		for(Integer num : numbers) {
			System.out.println(num);
		}
		//LinkedHashSets do keep order of insertion, unlike HashSets,
		//but duplicates are still not allowed
		
		//By default, the set will not be able to recognize that both
		//Dog objects have the same values and will insert both as it
		//will not recognize them as "equal values" because they are
		//different objects.
		LinkedHashSet<Animal> animals = new LinkedHashSet<Animal>();
		animals.add(new Animal("Dog", 12));
		animals.add(new Animal("Cat", 8));
		animals.add(new Animal("Bird", 3));
		animals.add(new Animal("Dog", 12));
		animals.add(new Animal("Kangaroo", 24));
		
		
		for(Animal animal : animals) {
			System.out.println(animal.toString());
		}
		
	}

}
