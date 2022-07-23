package com.imtiaz.exceptions;

public class PracticeException1 extends Exception {

	public static int subtract10FromLargerNumber(int number) throws PracticeException1 {

		if (number < 10) {
			// using "new" because PracticeException1 is a class
			throw new PracticeException1();
		}
		return number - 10;
	}

}
