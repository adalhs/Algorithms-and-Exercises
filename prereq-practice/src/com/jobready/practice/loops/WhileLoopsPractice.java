package com.jobready.practice.loops;

public class WhileLoopsPractice {

	public static void main(String[] args) {
		
		int counter = 0;
		
		while(counter < 5) {
			System.out.println(counter + 1);
			counter += 1;

			if(counter == 3) {
				break;
			}
		}

		String str = "We have a large inventory of things in our "
				+ "warehouse falling in the category: apparel and "
				+ "the slightly more in demand category: makeup along "
				+ "with the category: furniture and...";
		
		//The way I did it (proud of myself, 11 lines of code)
		printCategories(str);
		
		//The way Imtiaz did it (less code, 8 lines of code)
		printCategories2(str);
		
	}
	
	//Extract all categories from the string argument (way I did it)
	public static void printCategories(String str) {
		//Used as a pointer to look through the string
		int strIndex = 0;
		//Will hold category name
		String category = "";
		//While the pointer is not at the end of the string
		while(strIndex <= str.length() - 1) {
			//Whenever we get to a ":" in the string, there is
			//a category name afterwards
			if(str.charAt(strIndex) == ':') {
				//Moves the Index to the first letter of the
				//category word, it's +2 instead of 1 so it skips
				//the space after the ":"
				strIndex += 2;
				
				while(!(str.charAt(strIndex) == ' ')) {
				category += str.charAt(strIndex);
				strIndex += 1;
				}
				
				System.out.println(category);
				category = "";
			}
			
			strIndex += 1;
		}
	}
	
	//Extract all categories from the string argument (way Imtiaz did it)
	public static void printCategories2(String string) {
		int i = 0;
		while(true) {
			int found = string.indexOf("category: ", i);
			if (found == -1) break;
			int start = found + 10; //start of the actual category
			int end = string.indexOf(" ", start);
			System.out.println(string.substring(start, end));
			i = end + 1;  //so loop does not run infinitely
		}
	}

}
