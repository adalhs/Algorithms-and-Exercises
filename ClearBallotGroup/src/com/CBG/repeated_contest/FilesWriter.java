package com.CBG.repeated_contest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// Overwrites file without duplicates found
public class FilesWriter {

	public static void writeFile(String file, List<List<String>> valuesList) {
		// True in the writer's boolean will append to the file, instead of overwriting
		try (FileWriter writer = new FileWriter(file, true)) {
			for (int i = 0; i < valuesList.size(); i++) {
				for (int j = 0; j < valuesList.get(i).size(); j++) {
					// If (i + 1) % lineLength = 0, then I reached end of line, must start new one.
					if (j == valuesList.get(i).size() - 1) {
						writer.write(valuesList.get(i).get(j) + "\n");
					} else {
						writer.write(valuesList.get(i).get(j) + ",");
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error writing to " + file + " file.");
		}
	}

	public static void writeHeaders(String file, String[] headers) {
		// False in the writer's boolean will overwrite the file, instead of appending
		try (FileWriter writer = new FileWriter(file, false)) {
			for (int i = 0; i < headers.length; i++) {
				// If it's the last header
				if (i == headers.length - 1) {
					writer.write(headers[i] + "\n");
				} else {
					writer.write(headers[i] + ",");
				}
			}
		} catch (IOException e) {
			System.out.println("Error writing to " + file + " file.");
		}
	}
}
