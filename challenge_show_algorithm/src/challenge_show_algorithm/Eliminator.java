package challenge_show_algorithm;

import java.util.List;

public class Eliminator {

	// Static variable means its a common property for all objects, not different
	// for separate instances. Static variables are only initialized once
	static int eliminationRound = 0;

	public static void runElimination(List<String> partners, List<String> men, List<String> women)
			throws InterruptedException {
		eliminationRound += 1;

		// Numbers for choosing two random numbers (0 - 13) for elimination
		int randomTeam1 = 0 + (int) (Math.random() * partners.size());
		int randomTeam2 = 0 + (int) (Math.random() * partners.size());

		// If algorithm chooses same team for random2 as random1, chooses random2 again
		while (randomTeam1 == randomTeam2) {
			randomTeam2 = 0 + (int) (Math.random() * partners.size());
		}

		// This will hold the two teams up for elimination
		String[] eliminationPartners = { partners.get(randomTeam1), partners.get(randomTeam2) };

		System.out.println("Elimination number " + eliminationRound + " - " + eliminationPartners[0] + " vs "
				+ eliminationPartners[1] + "\nRunning elimination...");
		//Thread.sleep(7500);

		// The code below will choose a random number (either 1 or 2) to be the winner.
		// Then, if number 1 was chosen as the winner, that means number 2 must be the
		// loser, or vice versa. Then, in the sysout, I have to do -1 to these numbers
		// so that they can represent indexes 0 and 1 of the eliminationPartners Array.
		int randomWinners;
		int randomLosers;
		if ((randomWinners = 1 + (int) (Math.random() * 2)) == 1) {
			randomLosers = 2;
		} else {
			randomLosers = 1;
		}
		System.out.println("Elimination concluded.  The winners are " + eliminationPartners[randomWinners - 1] + ", "
				+ eliminationPartners[randomLosers - 1] + " have been eliminated.\n");

		// Removes names of eliminated man and woman from the "men" and "women" Lists by
		// getting them from their respective substrings in the eliminationPartners
		// Array's losing team String element.
		men.remove(
				eliminationPartners[randomLosers - 1].substring(0, eliminationPartners[randomLosers - 1].indexOf(" ")));
		women.remove(eliminationPartners[randomLosers - 1]
				.substring(eliminationPartners[randomLosers - 1].indexOf(" ") + 5));

		// Removing losing pair from partners List
		partners.remove(eliminationPartners[randomLosers - 1]);
		//Thread.sleep(7500);
		
	}

}
