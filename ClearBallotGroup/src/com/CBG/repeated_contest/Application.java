package com.CBG.repeated_contest;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		// Will hold any duplicate ContestIDs found in the contests.csv file
		List<String> duplicateContestIds = new ArrayList<>();

		// Finds duplicate contests in the contests.csv file, removes them, and returns
		// their ContestIDs to this List so we can check other files that may have them
		duplicateContestIds = new ArrayList<>(FilesReader.readFile("contests.csv", duplicateContestIds));
		System.out.println(duplicateContestIds.size() + " duplicate contest(s) found.");
		
		// Reads choices.csv file and writes a new choices.csv without the records that
		// include the illegal duplicate ContestID.
		FilesReader.readFile("choices.csv", duplicateContestIds);
	}

}
