package practice.strings;

public class StringsPractice {
	
	public static void main(String[] args) {
		
		String a = "Hello";
		System.out.println(a.length());
		
		String str = "ABCDEFG";
		String extractedString = str.substring(1, 3);
		System.out.println(extractedString);
		
		if(a == "Hello") {
			//This is a trap, don't do this
		}
		
		if(a.equals("Hello")) {
			//Use this
			System.out.println("yes, its equal");
		}
		
		//to ignore upper/lower case
		if(a.equalsIgnoreCase("heLLo")) {
			System.out.println("Ignoring upper/lower case");
		}
		
		System.out.println(a.charAt(0));
		
		//Can be used on symbols and numbers as well
		char myChar = 'H';
		char myChar2 = '}';
		char myChar3 = '3';
		
		//Finding first index where word is found
		String str2 = "Hello there yogi";
		int c = str2.indexOf("there");
		System.out.println(c);
		
		//Finding first index where word is found, after index 7
		str2 = "Hello there yogi there";
		c = str2.indexOf("there", 7);
		System.out.println(c);
		
		//Finding first index where word if found FROM RIGHT TO LEFT
		int d = str2.lastIndexOf("there");
		System.out.println(d);
		
		
	}
}
