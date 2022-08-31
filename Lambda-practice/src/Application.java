
public class Application {

	public static void main(String[] args) {

		Human tom = new Human();
		// walker(tom);

		Robot wale = new Robot();
		// walker(wale);

		// Before functional programming and lambdas, the closest we could get to that
		// was with an anonymous class, such as this one.
//		walker(new Walkable() {
//			@Override
//			public void walk() {
//				System.out.println("Custom object walking.");
//			}
//		});

		// With lambdas we don't need the name of the method, we can just specify what
		// we want the code to do. In this case, we want the code to just execute the
		// sysout statement we wrote. The lambda syntax needs the arrow, and the open
		// and close parenthesis before the arrow. If we were passing in any arguments,
		// they would go inside the parenthesis. After the arrow we write what we want
		// done. In this case, we only want one thing done...
		walker(() -> System.out.println("Custom object walking"));

		// ...but if we have multiple things that we want done, we wrap them in curly
		// braces and put a semicolon (;) after each statement, like below...
		walker(() -> {
			System.out.println("Thing walking.");
			System.out.println("The thing tripped.");
		});
		// Notice that in the above statements, we are invoking the walker method with
		// the lambda without using any arguments. When I do this, the method I invoke
		// will automatically default as if I had passed in a type "Walkable" element...

		// ...However, if I create a lambda like I am doing here, where I am assigning
		// the lambda to a variable, and then invoking the walker() method with that
		// variable, this will not work. The lambda assignment won't work, because
		// "AnotherInterface" is not a functional interface, it has two abstract methods
		// instead of only one, and the method call won't work because we are assigning
		// the variable "aBlockOfCode" to be type "AnotherInterface" and the walker()
		// method accepts "Walkable" type arguments.
//		AnotherInterface aBlockOfCode = (() -> {
//			System.out.println("Hello.");
//			System.out.println("I'm an interface with two abstract methods, so...");
//			System.out.println("I'm not a functional interface that can be used in lambdas.");
//		});
//		walker(aBlockOfCode);

		// More practice turning methods into lambdas, I create a functional interface
		// (ALambdaInterface), and give it the sayHello() method that appears below
		ALambdaInterface helloVar = () -> System.out.println("Hello there");

		// More practice turning methods into lambdas, in this case the sum() method
		// takes two arguments, this is how we do it. In the parenthesis we specify the
		// two arguments, then, after the arrow, we write what we want the code to do,
		// and in this case we want it to execute "return num1 + num2", which is what
		// the sum() method does. We don't have to write the keyword "return", because
		// the lambda can infer that that is what we want to do.
		InterfaceSum sumVar = (num1, num2) -> num1 + num2;

		// To use the lambdas above, I can do:
		System.out.println(sumVar.sum(4, 6));
		// don't have to use sysout on this one because the method already prints
		helloVar.sayHello();

		// More practice... notice here that, although we want it to do multiple
		// statements, because the first statement ends in a curly brace, we don't have
		// to use a semicolon at the end of it.
		InterfaceNonZeroDivide nonZeroDividerVar = (num1, num2) -> {
			if (num1 == 0) {
				return 0;
			}
			return num1 / num2;
		};
		System.out.println(nonZeroDividerVar.nonZeroDivide(16, 8));

		// More practice turning functional interface methods into lambdas
		InterfaceReverseString reverseVar = (s) -> {
			String result = "";
			for (int i = s.length() - 1; i >= 0; i--) {
				result += s.charAt(i);
			}
			return result;
		};
		System.out.println(reverseVar.reverseString("Hello"));

		// More practice turning functional interface into lambdas
		InterfaceFactorial factorialVar = (num) -> {
			int result = 1;
			for (int i = 1; i <= num; i++) {
				result = i * result;
			}
			return result;
		};
		System.out.println(factorialVar.factorial(5));

		// GENERIC
		InterfaceGeneric<String> myVar = (s) -> {
			String result = "";
			for (int i = s.length() - 1; i >= 0; i--) {
				result += s.charAt(i);
			}
			return result;
		};
		System.out.println(reverseVar.reverseString("Computer"));
		
		InterfaceGeneric<Integer> myVar2 = (num) -> {
			int result = 1;
			for (int i = 1; i <= num; i++) {
				result = i * result;
			}
			return result;
		};
		System.out.println(factorialVar.factorial(4));

	}

	public static void walker(Walkable walkableEntity) {
		walkableEntity.walk();
	}

	// More practice turning methods into lambdas
//	public void sayHello() {
//		System.out.println("Hello there.");
//	}

	// More practice turning methods into lambdas
//	public static int sum(int arg1, int arg2) {
//		return arg1 + arg2;
//	}

	// More practice turning methods into lambdas
//	public int nonZeroDivide(int arg1, int arg2) {
//		if (arg1 == 0) {
//			return 0;
//		}
//		return arg1 / arg2;
//	}

	// More practice turning methods into lambdas
//	public String reverseString(String str) {
//		String result = "";
//		for (int i = str.length() - 1; i >= 0; i--) {
//			result += str.charAt(i);
//		}
//		return result;
//	}

	// More practice turning methods into lambdas
	// (A factorial multiples the number by 1, then the result of that by 2, then
	// the result of that by 3... etc. until it reaches the number specified.
//	public int factorial(int num) {
//		int result = 1;
//		for (int i = 1; i <= num; i++) {
//			result = i * result;
//		}
//		return result;
//	}

	// The benefit of lambdas isn't just saving space, it is the fact that they
	// allow us to disassociate a set of instructions from an object. Allowing us to
	// use an object oriented language where blocks of code do not need to be
	// associated with a given object and can be used anywhere in the application.
	// However, if we think about it, we are having to write the same code of the
	// method called twice, and we have to create many interfaces. The good thing is
	// that the Java language actually comes with many functional interfaces
	// built-in that we can use...

	// ...Also, we can create GENERIC FUNCTIONAL INTERFACES that can not only help
	// us disassociate blocks of code from objects, but because they are generic,
	// they can be used by a wide variety of data types. The following interface...
	
	//public E doSomething(E someVar) {
		
	//}

}
