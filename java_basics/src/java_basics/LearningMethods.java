package java_basics;

import someotherpackage.ExampleClass;

public class LearningMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("askljdajgkh");
		MyUtils.printSomeJunk(34);
		MyUtils.sum2Numbers(10, 23);
		
		//Declaring a variable to hold the return value of
		//the add10 method in the MyUtils class and adding +1000 
		int myvar = MyUtils.add10(99) + 1000;
		
		//printing the value returned, and saved in myvar
		System.out.println(myvar);
		
		//Another way to use return values from methods,
		//right inside a print statement without assigning
		//the value to a variable
		System.out.println(MyUtils.multiplyBy2(50));
		
		
		ExampleClass.doSomething();
		
	}
	

}
