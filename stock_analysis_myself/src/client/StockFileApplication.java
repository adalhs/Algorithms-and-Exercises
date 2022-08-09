package client;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fileprocessors.StockFileReader;

public class StockFileApplication {

	public static void main(String[] args) {

		File file = new File("table.csv");
		StockFileReader.readFile(file);
	}

	public static void arrangeData(String[] headers, String[] values) {
		// This will hold the final arranged stock data
		List<HashMap<String, Double>> stockDataArray = new ArrayList<>();

		// For each line in the values String[] (251 lines)
		for (int i = 0; i < values.length; i++) {

			// Creating a new String[] to hold each value in each of the lines in the
			// "values" String[] as a separate index and be able to iterate over them
			String[] valueLine = values[i].split(",");

			// I am creating the HashMap here with each iteration because I want to clear()
			// the HashMap, but clearing it deletes any reference to it inside other
			// variables, so I would not be able to store it in the stockDataArray ArrayList
			HashMap<String, Double> stockDataMap = new HashMap<>();

			// For each index in the headers[]
			for (int j = 0; j < headers.length; j++) {
				stockDataMap.put(headers[j], Double.parseDouble(valueLine[j]));
			}
			stockDataArray.add(stockDataMap);
		}

		System.out.println(stockDataArray);
	}

}
