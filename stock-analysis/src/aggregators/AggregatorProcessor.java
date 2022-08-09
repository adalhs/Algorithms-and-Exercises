package aggregators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fileprocessors.StockFileReader;

//Specifying Generic data type, I am specifying this class can work with
//Aggregator or any child class of Aggregator
public class AggregatorProcessor <E extends Aggregator> {

	// Should I make this type Aggregator or type E?
	E agg;
	String file;

	public AggregatorProcessor(E agg, String file) {
		super();
		this.agg = agg;
		this.file = file;
	}

	public double runAggregator(int columnIndex) throws IOException {
		StockFileReader reader = new StockFileReader(file);

		// Puts the List<String> of lines returned from the readFileData() method in the
		// List<String> stockFileLines
		List<String> stockFileLines = reader.readFileData();

		/*
		 * Splits each of the six values in the line in "line" variable after the comma
		 * and adds them to separate indexes in the String [] values
		 */
		for (String line : stockFileLines) {
			String [] values = line.split(",");
			
			//Grabbing the value from the desired column (columnIndex - 1) to the dval variable and sending it to the add() method of agg (Aggregator)
			//to be added to a List of Doubles
			Double dval = Double.parseDouble(values[columnIndex - 1]);
			agg.add(dval);
		}
		
		return agg.calculate();
	}

}
