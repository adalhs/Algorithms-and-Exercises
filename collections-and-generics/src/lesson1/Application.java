package lesson1;
import java.util.ArrayList;
import java.util.LinkedList;

public class Application {

	public static void main(String[] args) {

		ArrayList<String> words = new ArrayList<String>();
		words.add("hello");
		words.add("there");
		words.add("10");
		
		String item1 = words.get(0);
	
		System.out.println(item1);
		
		
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		numbers.add(100);
		numbers.add(4100);
		numbers.add(1030);
		numbers.add(1009);
		
		for(int number : numbers) {
			System.out.println(number);
		}
	}

}
