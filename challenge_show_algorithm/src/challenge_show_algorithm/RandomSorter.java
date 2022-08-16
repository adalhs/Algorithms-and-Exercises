package challenge_show_algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomSorter {

	public static void sortRandomly(HashMap<String, Integer> pastTeams, List<String> currentTeams,
			HashMap<String, Integer> pairedBeforeMap, List<String> men, List<String> women) {

		currentTeams.clear();

		int randomMan;
		int randomWoman;

		// Will hold the names of men and women already paired with someone so they
		// are not chosen again
		List<String> menAlreadyPaired = new ArrayList<>();
		List<String> womenAlreadyPaired = new ArrayList<>();

		for (int i = 0; i < men.size(); i++) {
			randomMan = 0 + (int) (Math.random() * men.size());
			randomWoman = 0 + (int) (Math.random() * women.size());

			// While the "randomMan" random number belongs to the index of a man in the
			// "men" List that has already been assigned a pair... choose another randomMan
			while (menAlreadyPaired.contains(men.get(randomMan))) {
				randomMan = 0 + (int) (Math.random() * men.size());
				System.out.println("men");
			}

			// While the "randomWoman" random number belongs to the index of a woman in the
			// "women" List that's already been assigned a pair, choose another randomWoman
			while (womenAlreadyPaired.contains(women.get(randomWoman))) {
				randomWoman = 0 + (int) (Math.random() * women.size());
				System.out.println("women");
			}
			

			// Will hold the name of the man and woman paired to see if the "pastTeams"
			// HashMap points to that team having been paired before, and if they have, how
			// many times. How many times they've been paired before is important to know
			// because in case it is no longer possible for a man or woman to be paired with
			// any different person, the algorithm will put them again with someone with
			// whom they have been with the least amount of times.
			String pairing = men.get(randomMan) + " and " + women.get(randomWoman);

			boolean pairedBefore = false;
			// Iterates through all the past pairings. If the "pairing" String equals() any
			// of the keys in the "pastTeams" HashMap, then the team has been together
			// before and "pairedBefore" will be changed from "false" to "true", and that
			// entry from the "pastTeams" HashMap will be entered into "pairedBeforeMap"
			for (Map.Entry<String, Integer> entry : pastTeams.entrySet()) {
				if (entry.getKey().equals(pairing)) {
					pairedBefore = true;
					pairedBeforeMap.put(pairing, entry.getValue());
				}
			}

			if (pairedBefore == true) {
				String repeatedPair = null; // Will hold the names of the repeat partners to pass onto the
											// "currentTeams" and "pastTeams" maps. Repeat partners will be chosen going
											// by the one that has been together the least amount of times (lowest
											// getValue()). If there are multiple ones with the same getValue(), it will
											// choose the last entry scanned with that value because that is when the
											// for loop will end.
				int timesPaired = 9999999; // choosing high number to be safe

				//algorithm to check hashmap and see if both names are together, if both names
				//are together, check their getValue, if current man and woman have the lowest
				//getValue, get them, otherwise, send back to choose another woman
				for (Map.Entry<String, Integer> entry2 : pairedBeforeMap.entrySet()) {
					if (entry2.getValue() < timesPaired) {
						timesPaired = entry2.getValue();
						repeatedPair = entry2.getKey();
					}
				}
				// Adds the repeated pair to the "pastTeams" HashMap, incrementing the times
				// they have been together by 1 (so they won't be chosen again soon). Also adds
				// them to the "currentTeams" ArrayList.
				pastTeams.put(repeatedPair, timesPaired + 1);
				currentTeams.add(repeatedPair);
			}

			// If the loop above finished, and "pairedBefore" remained false, it means the
			// team has never been together, and assigns them to the pastTeams HashMap, with
			// "1" for the getValue(), meaning they have been together ONE time. Also
			// assigns them to the "currentTeams" ArrayList.
			if (pairedBefore == false) {
				pastTeams.put(pairing, 1);
				currentTeams.add(pairing);
			}

			// Adding indexes of paired men and women to Lists so they can be put in IF
			// above and not be chosen for pairing again
			menAlreadyPaired.add(men.get(randomMan));
			womenAlreadyPaired.add(women.get(randomWoman));
		}

	}

}
