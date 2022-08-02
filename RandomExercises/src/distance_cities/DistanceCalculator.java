package distance_cities;

import java.util.Map;
import java.util.TreeMap;

public class DistanceCalculator {

	//Static method, because I am not creating (instantiating) a calculator object in the main method
	public static void calculator(TreeMap<Integer, String> map) {

		int cityNumber = 1;
		int startingDistance = 0;
		String startingPoint = "";

		for (Map.Entry<Integer, String> result : map.entrySet()) {
			//If this is the first city, prints "...miles from starting point."
			if (cityNumber == 1) {
				System.out.println("City #" + cityNumber + ": " + result.getValue() + ". Distance: "
						+ (result.getKey() - startingDistance) + " miles from starting point.");
				
				//If this is not the first city, prints "...miles from <previous city> (held in startingPoint variable).
			} else {
				System.out.println("City #" + cityNumber + ": " + result.getValue() + ". Distance: "
						+ (result.getKey() - startingDistance) + " miles from " + startingPoint + ".");
			}
			cityNumber += 1;
			startingPoint = result.getValue();
			startingDistance = result.getKey();
		}

	}

}
