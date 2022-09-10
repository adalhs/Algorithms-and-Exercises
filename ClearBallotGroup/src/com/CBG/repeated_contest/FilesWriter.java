package com.CBG.repeated_contest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilesWriter {

	public static void writeFile(String file, List<List<String>> linesList) {
		// True in the writer's boolean will append to the file, instead of overwriting
		try (FileWriter writer = new FileWriter(file, true)) {
			for (int i = 0; i < linesList.size(); i++) {
				for (int j = 0; j < linesList.get(i).size(); j++) {
					// If it's the last element in a line
					if (j == linesList.get(i).size() - 1) {
						writer.write(linesList.get(i).get(j) + "\n");
					} else {
						writer.write(linesList.get(i).get(j) + ",");
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
