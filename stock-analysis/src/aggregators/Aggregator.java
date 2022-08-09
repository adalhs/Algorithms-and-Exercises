package aggregators;

import java.util.ArrayList;
import java.util.List;

//This is an abstract class, which means it's probably a parent of other classes
public abstract class Aggregator {
	
	//Any child of the Aggregator class will have access to List<Double> numbers
	List<Double> numbers;
	
	//This class has two constructors, if we instantiate an Object of class Aggregator with no arguments, the constructor
	//with no parameters will be called.  If we instantiate it with one argument, the constructor with one parameter will be called.
	public Aggregator(){
		numbers = new ArrayList<Double>();
	}
	
	public Aggregator(List<Double> numbers){
		numbers = new ArrayList<Double>(numbers);
	}
	
	/**
	 * add data to the given collection
	 * 
	 */
	public void add(Double number) {
		numbers.add(number);
	}
	/**
	 * Any class that is a derivative of the abstract class
	 * Aggregator must implement the calculate method (which returns a double),
	 * as well as the getValues method (which returns a List<Double>).
	 * @return double
	 */
	public abstract double calculate();
	
	public abstract List<Double> getValues();
	
}
