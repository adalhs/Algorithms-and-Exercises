package client;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dataprocessors.StockDataReader;
import dataprocessors.StockFileReader;

public class StockFileApplication {

	public static void main(String[] args) {

		File file = new File("table.csv");

		// Calls the StockDataReader class' readData() method, passing in the value
		// returned from the arrangeData() method, which took as a parameter the value
		// returned from StockFileReader class' readFile() method
		StockDataReader.readData(arrangeData(StockFileReader.readFile(file)));

		// I can do the above method of chain method calling, instead of declaring a
		// variable to hold the return value of each method and passing that on to the
		// next method.  Must be careful that its always readable though.
	}

	public static List<HashMap<String, Double>> arrangeData(String[] stockData) {
		// This will hold the final arranged stock data
		List<HashMap<String, Double>> arrangedStockData = new ArrayList<>();

		// Getting the headers from the first line of stockData Array and separating
		// them in different indexes to be able to iterate over them
		String[] headers = stockData[0].split(",");

		// For each line in the stockArray after the first one (which contains the
		// headers)
		for (int i = 1; i < stockData.length; i++) {

			// Creating a new String[] to hold each value in each of the lines in the
			// "stockData" String[] as a separate index and be able to iterate over them
			String[] values = stockData[i].split(",");

			// I am creating the HashMap here with each iteration because I want to clear()
			// the HashMap, but clearing it deletes any reference to it inside other
			// variables, so I would not be able to store it in the stockDataArray ArrayList
			HashMap<String, Double> stockDataMap = new HashMap<>();

			// For each index in the headers[]
			for (int j = 0; j < headers.length; j++) {
				stockDataMap.put(headers[j], Double.parseDouble(values[j]));
			}

			arrangedStockData.add(stockDataMap);
		}

		return arrangedStockData;
	}
}
