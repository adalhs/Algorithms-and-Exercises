package com.CBG.repeated_contest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilesReader {

	/**
	 * These variables must be declared static because we need them to keep their
	 * values as this Class is called multiple times from main.
	 * 
	 * The map will hold duplicate ContestIDs in the entry's keys and the
	 * corresponding correct ContestID in the entry's values. NOTE: Do not change
	 * duplicate ContestIDs from keys to values and correct Contest IDs from values
	 * to keys. This could lead to not adding all duplicates in case we have a file
	 * where ContestIDs are duplicated more than once, as a map cannot have multiple
	 * entries's keys with the same value. Duplicate ContestIDs are always
	 * different, correct ones will always be the same, so they should go in the
	 * entry's values.
	 * 
	 * The correctInformation List will hold information taken when reading the
	 * choices.csv file that is necessary to overwrite the ballotmapper.csv file.
	 */
	static Map<String, String> duplicateAndCorrectContestIDs = new HashMap<>();
	static List<List<String>> correctInformation = new ArrayList<>();

	public static void readFile(String file) {

		try (FileReader fileReader = new FileReader(file); BufferedReader reader = new BufferedReader(fileReader)) {
			String headers = reader.readLine();
			String[] headersArray = headers.split(",");

			// Getting relevant indexes in the current file, if they exist in it. We will
			// use these indexes to point to specific columns in the file being read.
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

			// Will hold all of the read file's lines except the headers.
			List<List<String>> linesList = new ArrayList<>();

			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineArray = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

				// Holds current line being read, separated into elements.
				List<String> currentLine = new ArrayList<>(Arrays.asList(lineArray));

				// If this is the first line being added to linesList (can't do the for loop
				// below when linesList.size is 0)
				if (file.equals("new contests.csv") && linesList.size() == 0) {
					linesList.add(currentLine);

				} else if (file.equals("new contests.csv")) {
					// Used to determine if a duplicate has been added to the map
					int initialDuplicatesListSize = duplicateAndCorrectContestIDs.size();

					for (List<String> fileLine : linesList) {
						// If line in linesList contains current line's ContestName, we have a duplicate
						if (fileLine.get(contestNameIndex).contains(currentLine.get(contestNameIndex))) {
							duplicateAndCorrectContestIDs.put(currentLine.get(contestIdIndex),
									fileLine.get(contestIdIndex));
						}
					}
					/*
					 * If when the for loop is done, the map size is the same as when we started the
					 * for loop, its because the current line does not contain any duplicates and we
					 * can add the line to the linesList.
					 */
					if (initialDuplicatesListSize == duplicateAndCorrectContestIDs.size()) {
						linesList.add(currentLine);
					}

				} else if (file.equals("new choices.csv")) {
					/*
					 * If map's keys (which hold duplicate ContestIDs) contain the current line's
					 * ContestID, the record will not be included in linesList, and we will add the
					 * record's ChoiceID that should be removed, the correct ChoiceID it should
					 * point to, and the correct ContestID (held in the map's values) to the
					 * correctInformation List.
					 */
					if (duplicateAndCorrectContestIDs.containsKey(currentLine.get(contestIdIndex)) == true) {
						System.out.println("Removed Choice ID " + currentLine.get(choiceIdIndex)
								+ " with illegal duplicate Contest ID " + currentLine.get(contestIdIndex));
						
						// MAYBE JUST GET THE CURRENT LINE'S INCORRECT CHOICE ID (INDEX 0), 
						// Will get the values to add to correctInformation List
						List<String> tempList = new ArrayList<>();

						// Adding INCORRECT ChoiceID (to overwrite the records with it in the
						// ballotmapper.csv file)
						tempList.add(currentLine.get(choiceIdIndex));
						// System.out.println("passed1");

						int processedChoiceID = Integer.MAX_VALUE;
						// Adding correct ChoiceID and ContestID
						for (List<String> fileLine : linesList) {

							// if (Integer.parseInt(fileLine.get(choiceIdIndex)) <= processedChoiceID) {

							for (Map.Entry<String, String> entry : duplicateAndCorrectContestIDs.entrySet()) {
								System.out.println("entries = " + duplicateAndCorrectContestIDs.size());
								// The map's entries hold DUPLICATE ContestIDs in the KEYS and corresponding
								// CORRECT ContestIDs in the VALUES. Will allow us to get the CORRECT ChoiceID
								// and CORRECT ContestID to overwrite necessary records in ballotmapper.csv
								if (fileLine.get(contestIdIndex).equals(entry.getValue())
										&& entry.getKey().equals(currentLine.get(contestIdIndex))) {

									System.out.println("ChoiceID in LINESLIST: " + fileLine.get(choiceIdIndex)
											+ " ChoiceID in CURRENT LINE: " + currentLine.get(choiceIdIndex));

									if (correctInformation.size() == 0) {
										tempList.add(fileLine.get(choiceIdIndex));
										tempList.add(entry.getValue());
										correctInformation.add(tempList);
										// processedChoiceID = Integer.parseInt(fileLine.get(choiceIdIndex));
									} else {
										boolean addedNew = false;
										for (List<String> info : correctInformation) {
//											if (info.get(1).equals(fileLine.get(choiceIdIndex))) {
//												wasIDProcessed = true;
//											} else {
//												wasIDProcessed = false;
//											}

											System.out.println("passed");
											System.out.println(correctInformation);

											if (correctInformation.indexOf(info) == correctInformation.size() - 1
													&& info.get(1).equals(fileLine.get(choiceIdIndex))) {
												System.out.println(fileLine);
												tempList.add(fileLine.get(choiceIdIndex));
												tempList.add(entry.getValue());
												addedNew = true;
												System.out.println("passed NEW");
											}
										}
										if (addedNew == true) {
											correctInformation.add(tempList);
										}

										// processedChoiceID = Integer.parseInt(fileLine.get(choiceIdIndex));

									}
									// Adding correct ChoiceID. We will use this to overwrite the incorrect
									// ChoiceIDs in the ballotmapper.csv file.
									// tempList.add(fileLine.get(choiceIdIndex));
									// System.out.println("passed2");

									// Adding Correct ContestID. We will use this to overwrite the incorrect
									// ContestIDs in the ballotmapper.csv file.
									// tempList.add(entry.getValue());
									// System.out.println("passed3");
								}
							}
							// }
						}

					} else {
						linesList.add(currentLine);
					}
				} else if (file.equals("ballotmapper.csv")) {

				}

			}
			System.out.println(correctInformation);
			FilesWriter.writeHeaders(file, headersArray);
			FilesWriter.writeFile(file, linesList);
		} catch (IOException e) {
			System.out.println("Error while reading the " + file + " file.");
		}
	}
}
