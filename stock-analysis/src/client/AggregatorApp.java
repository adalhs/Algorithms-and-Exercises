package client;

import java.io.IOException;

import aggregators.AggregatorProcessor;
import aggregators.MaxAggregator;

public class AggregatorApp {

	public static void main(String[] args) throws IOException {
		
		/**
			You'll need to uncomment the below code. You'll notice it does not compile!
			
			There are 2 objectives in this assignment.
			
			1).  Make sure the code compiles correctly after you uncomment it below.
			2).  Make sure it runs as explained in the assignment video!
			
			-->> YOUR WORK SHOULD BE DONE IN THE AggregatorProcessor CLASS. 
		**/

		MaxAggregator agg = new MaxAggregator();
		
		//This AggregatorProcessor will have a data of type MinAggregator.  We will make a new AggregatorProcessor with MinAggregator Object that must be instantiated
		//with a MinAggregator and a String variable
		AggregatorProcessor<MaxAggregator> aggsProcessor = new AggregatorProcessor<MaxAggregator>(agg, "table.csv");
		
		//Number in parenthesis is the column of the file I want to get
		double value = aggsProcessor.runAggregator(1);
		System.out.println(value);
	
	}

}
