package challenge_show_algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomSorter {

	public static void sortRandomly(HashMap<String, Integer> pastTeams, List<String> currentTeams, List<String> men,
			List<String> women) throws InterruptedException {

		System.out.println("Executing sorting algorithm...\nThe new team pairings are:");

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
			}

			// While the "randomWoman" random number belongs to the index of a woman in the
			// "women" List that's already been assigned a pair, choose another randomWoman
			while (womenAlreadyPaired.contains(women.get(randomWoman))) {
				randomWoman = 0 + (int) (Math.random() * women.size());
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
			// before and "pairedBefore" will be changed from "false" to "true".
			for (Map.Entry<String, Integer> entry : pastTeams.entrySet()) {
				if (entry.getKey().equals(pairing)) {
					pairedBefore = true;
					break;
				}
			}

			if (pairedBefore == true) {
				int timesPaired = 9999999; // choosing high number to be safe

				boolean okTeam = false;
				while (okTeam == false) {
					// Loops through all paired teams before
					for (Map.Entry<String, Integer> entry2 : pastTeams.entrySet()) {
						// If the current entry has been paired less than the previous lesser entry, AND
						// it contains the name of the man chosen, AND it contains the name of a woman
						// still in the "women" List (as in the possible pairings for the man, even
						// names of women who may have already gotten eliminated will show up) AND
						// "womenAlreadyPaired" List does not have the chosen woman's name in it, we
						// will hold that entry's key as the team that contains the man's name with the
						// least amount of pairings
						if (entry2.getValue() <= timesPaired && entry2.getKey().contains(men.get(randomMan))
								&& women.contains(entry2.getKey().substring(entry2.getKey().lastIndexOf(" ") + 1))
								&& !(womenAlreadyPaired
										.contains(entry2.getKey().substring(entry2.getKey().lastIndexOf(" ") + 1)))) {
							timesPaired = entry2.getValue();
							pairing = entry2.getKey();

							// Switches to true so loop is not executed again
							okTeam = true;
						}
					}

				}
				// Resetting to false so can test next team
				okTeam = false;

				// Adds the repeated pair to the "pastTeams" HashMap, incrementing the times
				// they have been together by 1 (so they won't be chosen again soon). Also adds
				// them to the "currentTeams" ArrayList.
				pastTeams.put(pairing, timesPaired + 1);
				currentTeams.add(pairing);
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
			menAlreadyPaired.add(pairing.substring(0, pairing.indexOf(" ")));
			womenAlreadyPaired.add(pairing.substring(pairing.lastIndexOf(" ") + 1));

			Thread.sleep(500);
			System.out.println(pairing.substring(0, pairing.indexOf(" ")) + " and "
					+ pairing.substring(pairing.lastIndexOf(" ") + 1));
			Thread.sleep(500);
		}

	}

}
