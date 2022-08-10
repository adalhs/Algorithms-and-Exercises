package client;

import java.io.File;
import java.util.Scanner;

import aggregators.Aggregator;
import dataprocessors.StockFileReader;

public class AggregatorApplication {

	public static void main(String[] args) {

		File file = new File("table.csv");
		String[] stockData = StockFileReader.readFile(file);

		// Will hold options for aggregator and stock data to evaluate
		int[] options = new int[2];
		presentOptions(options);

		// options[0] contains the aggregator option, options[1] contains the stock data
		// we want to analyze (High, Low, Open, etc.)
		switch (options[0]) {
		case 1:
			Aggregator.aggregateMax(stockData, options[1]);
			break;
		case 2:
			Aggregator.aggregateMin(stockData, options[1]);
			break;
		case 3:
			Aggregator.aggregateMean(stockData, options[1]);
			break;
		}

	}

	public static int[] presentOptions(int[] options) {
		int aggOption; // option of aggregator
		int stockDataOption; // option of stock data from file to show (High, Low, Open, Close, etc.)
		int aggTries = 0; // number of tries to get aggregator option right
		int stockTries = 0; // number of tries to get stock data option right

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome, which Aggregator do you want to use?\n");
		System.out.println("1 - Max Aggregator\n2 - Min Aggregator\n3 - Mean Aggregator\n");
		System.out.println("Type number of desired Aggregator and press Enter: ");

		// Getting option for which Aggregator to use
		while (aggTries < 3) {
			// if input is an int
			if (scanner.hasNextInt()) {
				aggOption = scanner.nextInt();

				// if number entered is not valid option
				if (aggOption > 3 || aggOption < 1) {
					aggTries++;
					if (aggTries == 3) {
						exitProgram();
					}
					System.out.println("That is not a valid option, please try again.");
				} else {
					// if a number was entered and is a valid option, break out of the loop (and use
					// up the leftover \n at the end of the input line so we can use the same
					// scanner in the next while loop)
					scanner.nextLine();
					options[0] = aggOption;
					break;
				}
				// if input is not a number
			} else {
				aggTries++;
				if (aggTries == 3) {
					exitProgram();
				}
				System.out.println("The input must be a number, please try again.");
				scanner.nextLine(); // Gets rid of the unused \n at end of input if a number was entered
			}
		}

		System.out.println("Choose which stock data you want to use the Aggregator on.\n");
		System.out.println("0 - Open\n1 - High\n2 - Low\n3 - Close\n4 - Volume\n5 - Adj Close\n");
		System.out.println("Type number of desired stock data: ");

		// Getting option for which stock data (Low, High, Open, etc.) I was to use the
		// Aggregator on
		while (stockTries < 3) {
			// if input is an int
			if (scanner.hasNextInt()) {
				stockDataOption = scanner.nextInt();

				// if number entered is not valid option
				if (stockDataOption > 5 || stockDataOption < 0) {
					aggTries++;
					if (aggTries == 3) {
						exitProgram();
					}
					System.out.println("That is not a valid option, please try again.");
				} else {
					// if a number was entered and is a valid option, break out of the loop
					options[1] = stockDataOption;
					break;
				}
				// if input is not a number
			} else {
				aggTries++;
				if (aggTries == 3) {
					exitProgram();
				}
				System.out.println("The input must be a number, please try again.");
				scanner.nextLine(); // Gets rid of the unused \n at end of input if a number was entered
			}
		}
		scanner.close();
		return options;
	}

	private static void exitProgram() {
		System.out.println("Locking system...");
		System.exit(0);
	}

}
