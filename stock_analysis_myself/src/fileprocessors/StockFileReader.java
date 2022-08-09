package fileprocessors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import client.StockFileApplication;

public class StockFileReader {

	public static void readFile(File file) {

		try (FileReader reader = new FileReader(file); BufferedReader buffReader = new BufferedReader(reader);) {

			String line;

			// Reads first line to add ("High", "Low", etc.) to "headers" Array
			line = buffReader.readLine();

			// Splitting the one line with all the headers into multiple indexes inside the
			// Array
			String[] headersArray = line.split(",");

			// Creating valuesList ArrayList (creating ArrayList here, because unlike the
			// headersArray above, I don't know how many lines this will have) and adding
			// values to it
			List<String> valuesList = new ArrayList<>();
			while ((line = buffReader.readLine()) != null) {
				valuesList.add(line);
			}

			// Creating valuesArray to pass values on to main method. I need a String[] to
			// be able to use the .split(",") method and enter each value separated by the
			// commas. I can do a String [] now because I put the values in the valuesList
			// List and now I know a size I can specify for the array (valuesList.size())
			String[] valuesArray = new String[valuesList.size()];
			for (int i = 0; i < valuesArray.length; i++) {
				valuesArray[i] = valuesList.get(i);
			}

			StockFileApplication.arrangeData(headersArray, valuesArray);

		} catch (FileNotFoundException e) {
			System.out.println("Cannot read stock data.  File not found.");
		} catch (IOException e1) {
			System.out.println("Error ocurred while reading file.");
		}
	}

}