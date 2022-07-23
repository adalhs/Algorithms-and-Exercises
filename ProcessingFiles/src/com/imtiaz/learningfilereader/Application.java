package com.imtiaz.learningfilereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//I can also just import java.io.* to import everything in that library
//but it can be a good idea to do separate imports to see all the classes
//I am using in the code

public class Application {

	public static void main(String[] args) {

		// Anytime I am creating an INSTANCE of a Class,
		// in this case, the "File" class, I must use the "new" keyword.
		// In this case I am creating a variable that POINTS to an
		// object that is an INSTANCE of the File class
		File file = new File("myfile.txt");

		try (FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);) {

			String line = bufferedReader.readLine();

			// Prints out data assigned to line and advances it to
			// the next line in the file
			while (line != null) {
				System.out.println(line);
				line = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("Problem reading file.");
		}

	}

}
