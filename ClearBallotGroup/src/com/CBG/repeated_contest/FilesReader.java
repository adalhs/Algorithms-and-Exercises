package com.CBG.repeated_contest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilesReader {

	public static List<String> readFile(String file, List<String> duplicateContestIds) {

		try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(fileReader)) {
			// Reading file headers
			String headers = reader.readLine();
			String[] headersArray = headers.split(",");

			// Getting relevant indexes in the current file, if they exist in it.
			int contestIdIndex = 0;
			int contestNameIndex = 0;
			int choiceIdIndex = 0;
			for (int i = 0; i < headersArray.length; i++) {
				if (headersArray[i].equals("ContestID")) {
					contestIdIndex = i;
				}
				if (headersArray[i].equals("ContestName")) {
					contestNameIndex = i;
				}
				if (headersArray[i].equals("ChoiceID")) {
					choiceIdIndex = i;
				}
			}

			// Will hold all elements from the read file lines.
			List<List<String>> valuesList = new ArrayList<>();

			String line; // Current line being read
			while ((line = reader.readLine()) != null) {
				String[] lineArray = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

				// Holds current line being read, separated by elements to pass to valuesList
				List<String> lineList = new ArrayList<>(Arrays.asList(lineArray));

				// If this is the first line being added to valuesList (can't do the for loop
				// below when valuesList.size is 0)
				if (file.equals("contests.csv") && valuesList.size() == 0) {
					valuesList.add(lineList);

				} else if (file.equals("contests.csv")) {
					// Used to determine if a duplicate has been added to duplicates List
					int initialDuplicatesListSize = duplicateContestIds.size();

					for (List<String> fileLine : valuesList) {
						// If valuesList contains current line's ContestName, we have a duplicate
						if (fileLine.contains(lineList.get(contestNameIndex))
								&& duplicateContestIds.contains(lineList.get(contestIdIndex)) == false) {
							duplicateContestIds.add(lineList.get(contestIdIndex));
						}
					}
					// If the for loop is done, and the duplicate's List size is the same as when we
					// started the for loop, the current line does not contain any duplicates and we
					// can add the line to the valuesList.
					if (initialDuplicatesListSize == duplicateContestIds.size()) {
						valuesList.add(lineList);
					}

					// If we are reading choices.csv file and the duplicates list contains its
					// contest ID will not add it to valuesList
				} else if (file.equals("choices.csv")) {
					if (duplicateContestIds.contains(lineList.get(contestIdIndex)) == true) {
						System.out.println("Removed Choice ID " + lineList.get(choiceIdIndex)
								+ " with illegal duplicate Contest ID " + lineList.get(contestIdIndex));
					} else {
						valuesList.add(lineList);
					}
				} else if (file.equals("ballotmapper.csv")) {
					// Need a List to save the correct contest number when going through the
					// contests.csv file that will save the contest ID ALREADY IN THE valuesList
					// whose ContestName matches the duplicate's ContestName. Right now I am only
					// saving the duplicate's ID, but now I need the CORRECT one's ID for the
					// ballotmapper.csv file.

					// When adding to choices.csv file, need a map that will save the choice IDs
					// (key) of any records whose contest ID corresponds to the correct contest IDs
					// (in this case only one), and save the them. Choice ID will be key, contest
					// IDs will be value.

					// Then, when reading the ballotmapper.csv file, if any of the choice IDs in the
					// map above are found in the ChoiceID index of the line, add to valuesList all
					// indexes of the lineList EXCEPT the one with ChoiceID and ContestID, and
					// instead add to those respective indexes the map's key (which holds the
					// choiceID), and value (which holds the contestID)
				}

			}

			FilesWriter.writeHeaders(file, headersArray);
			FilesWriter.writeFile(file, valuesList);
		} catch (IOException e) {
			System.out.println("Error while reading the " + file + " file.");
		}
		return duplicateContestIds;
	}
}
