package com.jobready.practice.loops;

public class ForLoopsPractice {

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			System.out.println("i: " + i);
		}
		
		String name = "Adalberto";
		
		//Loop that iterates through the string
		for (int i = 0; i < name.length(); i++) {
			System.out.println(name.charAt(i));
		}
		
		//Loop that iterates through the string backward
		for (int i = name.length() - 1; i >= 0; i--) {
			System.out.println(name.charAt(i));
			}
		
		//Loop that prints all even numbers between 0 and 10 (inclusive)
		for (int i = 0; i <=10; i += 2) {
			System.out.println(i);
		}
		
		for(int idx = 0; idx < 5; idx++) {
			for(int j = 0; j < 5; j++) {
				System.out.println("The value of idx was " + idx);
			}
		}
	}

}
