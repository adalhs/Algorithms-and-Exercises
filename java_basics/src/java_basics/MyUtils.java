package java_basics;

public class MyUtils {

	public static void printSomeJunk(String arg) {
		System.out.println("some blah blah");
	}
	
	//Even though both methods have the same name, java
	//knows that when I invoke the printSomeJunk method from the main method in
	//LearningMethods Class, I am passing in an integer argument (number 34),
	//so it automatically chooses that method
	public static void printSomeJunk(int arg) {
		System.out.println("Integer passed in: " + arg);
	}
	
	public static void sum2Numbers(int firstArg, int secondArg) {
		System.out.println(firstArg + secondArg);
	}
	
	public static int add10(int someArgument) {
		int result = someArgument + 10;
		return result;
	}
	
	public static int multiplyBy2(int arg) {
		int result = arg * 2;
		return result;
	}
}
