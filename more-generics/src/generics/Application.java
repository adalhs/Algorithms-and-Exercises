package generics;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Application {

	public static void main(String[] args) {

		/**
		 * If the <> are not added at the end, it will still treat the class as a raw
		 * type, meaning its arguments would just be type Object instead of type Integer
		 * and String.
		 * 
		 * This is now generic because the Container Class is fully generic. We can now
		 * put whatever we want in container as long as we specify the type. The
		 * Container Class was made generic by giving it a generic name to the values it
		 * should expect (i1, and i2 mean nothing) Generics help keep the promise of
		 * developer flexibility without sacrificing the benefits of type-safety at
		 * compile time by still having to specify types
		 */
		Container<Integer, String> container = new Container<>(12, "Hello");
		int val1 = container.getItem1();
		String val2 = container.getItem2();

		// Here I could make another Container type variable that takes in
		// two different data types (Double and Integer) than the one
		// above (Integer and String). This is what generics allow us to do.
		Container<Double, Boolean> container2 = new Container<>(2.12, false);
		double val3 = container2.getItem1();
		boolean val4 = container2.getItem2();

		/*
		 * Must make sure I also set the types for both the variables used in the
		 * Generic method and the HashSet objects, otherwise it won't matter that the
		 * method is generic, and will still treat them as raw types, not knowing what
		 * type data is going into them.
		 */
		Set<String> mySet1 = new HashSet<String>();
		mySet1.add("first");
		mySet1.add("second");
		mySet1.add("whatever");
		Set<String> mySet2 = new HashSet<String>();
		mySet1.add("first");
		mySet1.add("second");
		mySet1.add("Computer");
		Set<String> resultSet = union(mySet1, mySet2);

		/*
		 * The Iterator class is a nice, easy way to iterate over something, it requires
		 * the import java.util.Iterator. Note, that the Iterator as well needs to have
		 * a type specified so we're not using the raw type. The problem with not
		 * specifying a type of data and leaving the raw type when using generics is
		 * that we will be able to pass any type of data that we want, but then we will
		 * be able to do things with that data that we shouldn't do, like subtracting
		 * two strings for example. If we specify that the type of data is String, at
		 * compile time java will let us know that is not possible with an error.
		 */
		Iterator<String> itr = resultSet.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	/*
	 * To make this method generic... the first <E> we are specifying that we will
	 * be using E, a generic type parameter in the method (like in Generic classes,
	 * I can specify more than one generic type parameter (<E, K, V, etc.>) and that
	 * will let the compiler know those parameters have a significance in the
	 * method). The second E (Set<E>) is the return type of the method, and the E's
	 * inside the () are the type(which is generic and can change) of set1 and set2.
	 */
	public static <E> Set<E> union(Set<E> set1, Set<E> set2) {
		// Does not need the E in the second <> from Java 7 onwards,
		// only putting it there for clarity.
		Set<E> result = new HashSet<E>(set1);
		result.addAll(set2);
		return result;
	}

}
