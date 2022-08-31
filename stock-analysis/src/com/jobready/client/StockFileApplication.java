package com.jobready.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jobready.fileprocessors.StockFileData;
import com.jobready.fileprocessors.StockFileReader;

public class StockFileApplication {

	public static void main(String args[]) throws IOException {
		StockFileReader fr = new StockFileReader("table.csv");

		List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
		StockFileData fileData = new StockFileData();
		fileData.addData(dataResult);
		fileData.printData();
	}

	/**
	 * Complete the method body so that it returns the given structure needed to
	 * populate the data field in the StockFileData class.
	 * 
	 * @param headers
	 * @param lines
	 * @return List
	 */
	public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines) {
		List<HashMap<String, Double>> dataResult = new ArrayList<>();

		// Iterates over each line in the "lines" List<String> and saves
		// it to the "line" variable
		for (String line : lines) {
			// Splits each of the six values in the line in "line" variable
			// after the comma and adds them to separate indexes in the
			// String [] values
			String[] values = line.split(",");

			// Will be used to iterate through the "headers" List<String>
			// values 0 through 5 which contain the words "High", "Low",
			// "Open", etc.
			int counter = 0;

			// Will be used to save each HashMap and pass it on as an argument
			// to the List<HashMap<String, Double>> "dataResult". A new HashMap
			// object is created every time the above for loop is ran because
			// if I clear the previous HashMap object to enter new data in it,
			// the data will also be lost from the List<HashMap<String, Double>>
			// "dataResult" below.
			HashMap<String, Double> headersAndValuesMap = new HashMap<>();

			// Iterates through the String[] "values" array that at this point
			// will contain 6 indexes with the dollar values in the current line
			// and saves them to the "value" variable
			for (String value : values) {

				// Converts the "value" variable to double
				double dval = Double.parseDouble(value);

				// Adds the headers(0-5) values ("High", "Low", etc.) as keys
				// along with the dollar value converted to double to the Map
				headersAndValuesMap.put(headers.get(counter), dval);
				counter++;
			}

			// Adds the Map to the List<HashMap<String, Double>> "dataResult"
			dataResult.add(headersAndValuesMap);
		}
		// Prints the number of lines in dataResult (for debugging purposes
		// only), there should be 251 lines, as there are 252 in the .csv file
		// but the first line is the headers.
		System.out.println(dataResult.size());

		return dataResult;
	}

}
