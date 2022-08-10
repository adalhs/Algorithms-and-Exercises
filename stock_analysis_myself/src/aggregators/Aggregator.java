package aggregators;

public class Aggregator {

	public static void aggregateMax(String[] stockData, int stockDataOptionValue) {

		// Will hold the headers from first index of "stockData" Array and split them in
		// their own indexes in the new Array "headers"
		String[] headers = stockData[0].split(",");

		System.out.println("Running Max Aggregator on stock data '" + headers[stockDataOptionValue] + "'...");

		double maxValue = 0;

		// Loop through the VALUES of the "stockData" Array (i starts at 1 to not get
		// the index with the headers
		for (int i = 1; i < stockData.length; i++) {
			// Splits each value in the line of "stockData" Array into their separate
			// indexes, starting with the values beginning on second index (1)
			String[] values = stockData[i].split(",");

			// If the value in the "values" array index position that corresponds to the
			// option we want to test (stockDataOptionValue) is greater than maxValue (which
			// originally holds 0), then keep that as the maxValue until/if a higher number
			// comes along
			if (Double.parseDouble(values[stockDataOptionValue]) > maxValue) {
				maxValue = Double.parseDouble(values[stockDataOptionValue]);
			}
		}

		// Prints the header that corresponds to the data we want to evaluate, along
		// with its maxValue
		System.out.println("The highest value on stock data '" + headers[stockDataOptionValue] + "' is " + maxValue);
	}

	public static void aggregateMin(String[] stockData, int stockDataOptionValue) {

		// Will hold the headers from first index of "stockData" Array and split them in
		// their own indexes in the new Array "headers"
		String[] headers = stockData[0].split(",");

		System.out.println("Running Min Aggregator on stock data '" + headers[stockDataOptionValue] + "'...");

		// Setting initially very high number of minValue to have a safe number so that
		// we can then get a value from the file when we first do a "less than"
		// comparison
		double minValue = 999999999.00;

		// Loop through the VALUES of the "stockData" Array (i starts at 1 to not get
		// the index with the headers
		for (int i = 1; i < stockData.length; i++) {
			// Splits each value in the line of "stockData" Array into their separate
			// indexes, starting with the values beginning on second index (1)
			String[] values = stockData[i].split(",");

			// If the value in the "values" array index position that corresponds to the
			// option we want to test (stockDataOptionValue) is lesser than minValue (which
			// originally holds a very high number to choose a safe number for the first
			// comparison), then keep that as the minValue until/if a lower number
			// comes along
			if (Double.parseDouble(values[stockDataOptionValue]) < minValue) {
				minValue = Double.parseDouble(values[stockDataOptionValue]);
			}
		}

		// Prints the header that corresponds to the data we want to evaluate, along
		// with its maxValue
		System.out.println("The lowest value on stock data '" + headers[stockDataOptionValue] + "' is " + minValue);
	}

	public static void aggregateMean(String[] stockData, int stockDataOptionValue) {

		// Will hold the headers from first index of "stockData" Array and split them in
		// their own indexes in the new Array "headers"
		String[] headers = stockData[0].split(",");

		System.out.println("Running Mean Aggregator on stock data '" + headers[stockDataOptionValue] + "'...");

		double accumulator = 0;

		// Loop through the VALUES of the "stockData" Array (i starts at 1 to not get
		// the index with the headers
		for (int i = 1; i < stockData.length; i++) {
			// Splits each value in the line of "stockData" Array into their separate
			// indexes, starting with the values beginning on second index (1)
			String[] values = stockData[i].split(",");

			accumulator += Double.parseDouble(values[stockDataOptionValue]);
		}

		// Prints the header that corresponds to the data we want to evaluate, along
		// with its mean (stockData.length - 1 because the first line contains the
		// headers and no values
		System.out.println("The mean value on stock data '" + headers[stockDataOptionValue] + "' is "
				+ accumulator / (stockData.length - 1));
	}

}
