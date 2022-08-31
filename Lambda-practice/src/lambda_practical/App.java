package lambda_practical;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class App {

	public static void main(String[] args) {

		List<Car> cars = Arrays.asList(new Car("Honda", "Accord", "Red", 22300),
				new Car("Honda", "Civic", "Blue", 17700), new Car("Toyota", "Land Cruiser", "White", 48500),
				new Car("Toyota", "Corolla", "Black", 16200), new Car("Toyota", "Camry", "Blue", 24000),
				new Car("Nissan", "Sentra", "White", 17300), new Car("Mitsubishi", "Lancer", "White", 20000),
				new Car("Jeep", "Wrangler", "Red", 24500));

		// I want to create a Car object and return a String representation...
		// Car is the type it takes, String is the return
		// We only want to see the price and color
		Function<Car, String> priceAndColor = (c) -> "Price = " + c.getPrice() + " Color = " + c.getColor();
		String stringCar = priceAndColor.apply(cars.get(0));
		System.out.println(stringCar);

		// I will now just be calling one method instead of two.
		// printCarsPriceRange(cars, 18000, 22000);
		// printCarByColor(cars, "Red");

		// Passing in the "cars" List and for the second argument (CarCondition), I can
		// use a lambda or an anonymous class whose data type is the CarCondition
		// interface, which is what I went with here. This test() method will return
		// whatever we want it to return, either true or false, based on the criteria
		// that we give it.
//		System.out.println("Printing cars between price 18000 and 22000");
//		printCars(cars, new CarCondition() {
//			@Override
//			public boolean test(Car c) {
//				return c.getPrice() >= 18000 && c.getPrice() <= 22000;
//			}
//		});
		// Also utilizing the same test() method from the CarCondition interface here
//		System.out.println("Printing all cars that are blue.");
//		printCars(cars, new CarCondition() {
//			@Override
//			public boolean test(Car c) {
//				return c.getColor().equals("Blue");
//			}
//		});
		// This makes it so we're not hard-coding things, making them more flexible and
		// also allows for more polymorphism. But now, I'm going to turn the two
		// "printCars" methods above and change the second argument to a lambda
		// expression, rather than an anonymous class...

		// ...and we do it like this. We can see that a lambda expression allows us to
		// represent an interface and a representation of its method. We can see below,
		// in the printCars() method, that the second argument is an object of type
		// "CarCondition", which is an interface, but it only needs that because it
		// invokes the test() method argument within in the IF statement. So, if all it
		// needs is the method from the interface object, then we can use a lambda as
		// the second argument in printCars as we are doing here, because a lambda
		// expression represents a specific implementation of an interface's abstract
		// method, without having to create different interfaces or classes for all the
		// different implementations we want.
		// NOTE: Don't need a return statement because its only one line.
		// NOTE2: The "c" in () is because the test() method of the interface takes in
		// an argument.
		System.out.println("\nDoing the same with lambdas:");
		printCars(cars, (c) -> c.getPrice() >= 18000 && c.getPrice() <= 22000);
		printCars(cars, (c) -> c.getColor().equals("Blue"));
	}

//	@FunctionalInterface
//	interface CarCondition {
//		public boolean test(Car c);
//	}

	// Making above Interface with Generic type to allow even more user flexibility,
	// just naming it "Condition" instead of "CarCondition" and now the user can
	// pass any type of object, not just Car.
//	@FunctionalInterface
//	interface Condition<T> {
//		public boolean test(T t);
//	}
	// Finally just changing this for the Java built-in interface "Predicate" which
	// accepts one argument and returns a boolean parameter, and allows the user to
	// perform true/false checks on many different kinds of conditions, just by
	// passing the condition, so I'm just commenting it out.

	// Instead of having a separate methods to print cars by price range and by
	// color, I can combine them into this one
//	public static void printCars(List<Car> cars, CarCondition condition) {
//		for (Car c : cars) {
//			if (condition.test(c) == true) {
//				c.printCar();
//			}
//		}
//	}

	// Making above method accept interface with Generic type to allow even more
	// user flexibility, now I have to specify "Condition<Car>", on the second
	// argument, instead of just "Condition", because I have to specify what type of
	// data I am passing in to the Generic interface, since now it can accept any
	// type of data.
	public static void printCars(List<Car> cars, Predicate<Car> predicate) {
		for (Car c : cars) {
			if (predicate.test(c) == true) {
				c.printCar();
			}
		}
	}
	// Finally just changing this to use the java built-in interface "Predicate",
	// which accepts one argument and returns a boolean parameter, and allows the
	// user to perform true/false checks on many different kinds of conditions, just
	// by passing the condition
}

//  I condensed these two methods into just the one above thanks to lambdas
//  public static void printCarsPriceRange(List<Car> cars, int low, int high) {
//		for (Car c : cars) {
//			if (low <= c.getPrice() && c.getPrice() <= high) {
//				c.printCar();
//			}
//		}
//	}
//
//	public static void printCarByColor(List<Car> cars, String color) {
//		for (Car c : cars) {
//			if (c.getColor().equals(color)) {
//				c.printCar();
//			}
//		}
//	}
//}