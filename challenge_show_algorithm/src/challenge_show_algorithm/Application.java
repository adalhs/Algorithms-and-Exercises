package challenge_show_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Application {

	public static void main(String[] args) throws InterruptedException {

		List<String> men = new ArrayList<>(Arrays.asList("Tyson", "David", "Xavier", "Ben", "Kyland", "Leo", "Domenick",
				"Cashel", "Cinco", "Enzo", "Javonny", "Derek", "James", "Danny"));

		List<String> women = new ArrayList<>(Arrays.asList("Angela", "Cayla", "Tasha", "Alyssa", "Azah", "Tiffany",
				"Justine", "Kyra", "Desi", "Sarah", "Cely", "Cashay", "Shannon", "Shan"));

		// Creating initial pairings
		List<String> currentPartners = new ArrayList<>();
		System.out.println("Welcome to the Challenge USA!\nThe initial team pairings are:");
		for (int i = 0; i < men.size(); i++) {
			currentPartners.add(men.get(i) + " and " + women.get(i));
			Thread.sleep(1000);
			System.out.println(currentPartners.get(i));
		}
		Thread.sleep(1000);

		// Will hold past partners as the entryKey, along with a number as entryValue
		// that will represent how many times that team has been paired together.
		HashMap<String, Integer> pastPartners = new HashMap<>();
		// Adding POSSIBLE teams, entryValue of 0 as none of these would have been
		// paired yet.
		for (String man : men) {
			for (String woman : women) {
				pastPartners.put(man + " and " + woman, 0);
			}
		}

		// Adding INITIAL teams, entryValue of 1 as these will have been paired once.
		for (String team : currentPartners) {
			pastPartners.put(team, 1);
		}

		// Runs these while there is still more than one team.
		while (currentPartners.size() > 1) {
			// Runs elimination, eliminates losing pair from partners List as well pair's
			// team mates' names from the men and women Lists
			Eliminator.runElimination(currentPartners, men, women);

			// Will stop sorting people after the elimination where currentPartners.size()
			// will be dropped to one, as those are the winners.
			if (currentPartners.size() > 1) {
				RandomSorter.sortRandomly(pastPartners, currentPartners, men, women);
			}
		}

	}

}
