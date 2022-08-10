package dataprocessors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockFileReader {

	public static String[] readFile(File file) {

		try (FileReader reader = new FileReader(file); BufferedReader buffReader = new BufferedReader(reader);) {

			String headers;
			String line;

			// Reads first line to add ("High", "Low", etc.) to a String variable
			headers = buffReader.readLine();

			// Creating valuesList ArrayList and adding lines after the first one (the
			// headers), to it to save the values, since the header line was read above
			List<String> valuesList = new ArrayList<>();
			while ((line = buffReader.readLine()) != null) {
				valuesList.add(line);
			}

			// Creating stockDataArray to pass the headers and values on to main method. I
			// need it to be a String[] and not an ArrayList to be able to use the
			// .split(",") method (since table.csv is a comma delimited file) and enter each
			// header and value as separate elements in different indexes to be able to loop
			// through them in the arrangeData() method in Application Class. I can do a
			// String [] now because I put the values in the valuesList List first and now I
			// know a size I can specify for the array (valuesList.size() + 1). This will
			// make the String[] size 251 (the lines with the values) + 1 (the first line
			// with the headers) = 252.
			String[] stockDataArray = new String[valuesList.size() + 1];

			// Adding the first line of headers I got at the beginning on the method.
			stockDataArray[0] = headers;

			// Starting from int = 1 because stockDataArray[0] has the headers, now I need
			// to store the values. valuesList.get() has to be i - 1 because that List
			// contains the values and only the values, so if we did just "i", we would be
			// skipping over the first line of values, as "i" is set to 1 and not 0
			for (int i = 1; i < stockDataArray.length; i++) {
				stockDataArray[i] = valuesList.get(i - 1);
			}
			
			return stockDataArray;

		} catch (FileNotFoundException e) {
			System.out.println("Cannot read stock data.  File not found.");
		} catch (IOException e1) {
			System.out.println("Error ocurred while reading file.");
		}
		
		return null;
	}

}