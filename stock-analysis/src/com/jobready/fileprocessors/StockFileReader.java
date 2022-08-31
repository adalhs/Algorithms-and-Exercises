package com.jobready.fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {

	String filePath = null;

	public StockFileReader(String filePath) {
		this.filePath = filePath;
	}

	public List<String> getHeaders() throws IOException {
		String line = readFirstLine(filePath);

		/**
		 * This splits the String returned: "Open,High,Low,Close,Volume,Adj Close"
		 * whenever a comma is encountered in the line, effectively entering it into the
		 * "header" array at 6 different strings each in its own index. Even though the
		 * table.csv file's data doesn't seem to contain any commas, it is a .csv
		 * (comma-separated values) file, so whenever it is read, there is a comma after
		 * every value. The .split() method is only available to String Arrays, which is
		 * why I am creating a new String[] variable here to hold the values from the
		 * line.split()
		 **/
		String[] header = line.split(",");

		/**
		 * I need to return this as a List of Strings so it can have the same type as
		 * the argument it is being returned as. This is why I cannot simply leave it in
		 * the String[] "header", as that belongs to the Array Class, not the List
		 * Class, as both the "values" ArrayList, and the "dataResult" List of HashMaps
		 * it is being returned to.
		 */
		List<String> values = new ArrayList<String>();

		// Assigns the values of the Array passed in as a List.
		values = Arrays.asList(header);
		return values;

	}

	static String readFirstLine(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			// Reads one line from the file, if wanted to read more would probably need a
			// For Loop until no lines left.
			return br.readLine();
		}
	}

	/**
	 * Complete the body of this method.
	 * 
	 * @return List
	 * @throws IOException
	 */
	public List<String> readFileData() throws IOException {
		List<String> lines = new ArrayList<>();

		String line = null;

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			// Reading first line and doing nothing so it is not added to "line" variable
			br.readLine();

			// Advancing from second line onwards.  While the line in the file
			//isn't null it saves it to the "line" variable and adds it to the
			//"lines" List<String>
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			return lines;
		}
	}
}
