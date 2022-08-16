package challenge_show_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Application {

	public static void main(String[] args) throws InterruptedException {

		List<String> men = new ArrayList<>(Arrays.asList("Xavier", "Tyson", "Leo", "Kyland", "Javonny", "James", "Enzo",
				"Domenick", "Derek", "David", "Danny", "Cinco", "Cashel", "Ben"));

		List<String> women = new ArrayList<>(Arrays.asList("Tiffany", "Tasha", "Angela", "Shannon", "Shan", "Sarah",
				"Kyra", "Alyssa", "Justine", "Desi", "Cely", "Cayla", "Cashay", "Azah"));

		List<String> currentPartners = new ArrayList<>();
		// Creating initial pairings
		for (int i = 0; i < men.size(); i++) {
			currentPartners.add(men.get(i) + " and " + women.get(i));
		}

		// Will hold past partners as the entryKey, along with a number as entryValue
		// that will represent how many times that team has been paired together. That
		// number will be "1" for every team here, as they will have only been paired
		// once up to this point.
		HashMap<String, Integer> pastPartners = new HashMap<>();
		for (String team : currentPartners) {
			pastPartners.put(team, 1);
		}

		// Will hold pairs that been put together before in case that it is not possible
		// to put a person with someone they have never been with, the next best thing
		// is to put the with the person they have been least amounts of time with (used
		// in RandomSorter.sortRandomly()).
		LinkedHashMap<String, Integer> pairedBeforeMap = new LinkedHashMap<>();

		while (currentPartners.size() > 1) {
			// Runs elimination, eliminates losing pair from partners List as well pair's
			// team mates' names from the men and women Lists
			Eliminator.runElimination(currentPartners, men, women);

			// Will stop sorting people after the elimination where currentPartners.size()
			// will be dropped to one, as those are the winners.
			if (currentPartners.size() > 1) {
				RandomSorter.sortRandomly(pastPartners, currentPartners, pairedBeforeMap, men, women);
			}
		}

	}

}
