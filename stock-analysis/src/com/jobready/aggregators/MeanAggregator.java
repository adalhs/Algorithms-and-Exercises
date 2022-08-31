package com.jobready.aggregators;

import java.util.List;

public class MeanAggregator extends Aggregator{
	
	public double calculate() {
		double result = 0;
		if(!numbers.isEmpty()){
			double value = 0.00;
			
			//Number is the parent of classes that represent numeric values
			for(Number number : numbers){
				
				//specifies the Number object is of type double
				value+=number.doubleValue();
			}
			result = value/numbers.size();
		}
		return result;
	}

	@Override
	public List<Double> getValues() {
		return numbers;
	}

}
