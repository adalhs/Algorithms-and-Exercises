package streams_pratical;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {

	public static void main(String[] args) throws IOException {

		// Examples of Streams, they make heavy use of lambdas, but they don't all have
		// to include lambdas. A "source" and a "terminal operation" are mandatory.
		// "Intermediate operations" are optional..

		// STREAMS EXAMPLE 1
		// Source: "IntStream.range(1, 10)"
		// Intermediate Operation: None used.
		// Terminal Operation: ".forEach((x)"
		// NOTE: .range() is not inclusive of the last value
		IntStream.range(1, 10).forEach((x) -> System.out.println(x));
		System.out.println();

		// STREAMS EXAMPLE 2
		// Integer Stream with Skip
		// Source: "IntStream.range(1, 10)"
		// Intermediate Operation: ".skip(5)" (skips the first 5 elements)
		// Terminal Operation: ".forEach((x)"
		IntStream.range(1, 10).skip(5).forEach((x) -> System.out.println(x));
		System.out.println();

		// STREAMS EXAMPLE 3
		// Integer Stream with Sum
		// Source: "IntStream.range(1, 5)"
		// Intermediate operation: None used
		// Terminal operation: ".sum()" (sums numbers in range (not inclusive of last
		// number)
		int val = IntStream.range(1, 5).sum();
		System.out.println(val);
		System.out.println();

		// STREAMS EXAMPLE 4
		// Stream.of, sorted and findFirst
		// Source: "Stream.of("Hello", "bottle", "Africa")"
		// Intermediate operation: ".sorted()" (does what it says)
		// Terminal operation: ".findFirst()" (picks out the first element)
		// NOTE: "ifPresent()" is there to prevent NullPointerExceptions, it is a good
		// idea to put this when we are working with Streams like this because a
		// particular element might be null.
		Stream.of("Hello", "bottle", "Africa").sorted().findFirst().ifPresent((x) -> System.out.println(x));
		System.out.println();

		// STREAMS EXAMPLE 5
		// Stream from Array, sort, filter and print
		// Source: "Stream.of(items)"
		// Intermediate operation 1: ".filter()"
		// Intermediate operation 2: ".sorted()"
		// Terminal operation: ".forEach()"
		String[] items = { "car", "computer", "toothpaste", "box", "pencil", "tent", "door", "toy" };
		// Will only pull the words that start with "t" and sort them
		Stream.of(items).filter((x) -> x.startsWith("t")).sorted().forEach(x -> System.out.println(x + ", "));
		System.out.println();

		// STREAMS EXAMPLE 6
		// Average of squares of an int Array
		// Arrays.stream() is an Array method that allows us to Stream an Array
		// Source: "Arrays.stream(new int[] { 2, 4, 6, 8, 10 })"
		// Intermediate operation: ".map((x) -> x * x)" (every number will be mapped to
		// the square)
		// Terminal operation: ".average()" (calculates the average of all the numbers,
		// in this case will calculate the average of the squares of the numbers,
		// because the x's are being mapped to their squares)
		// NOTE: "ifPresent()" is there to prevent NullPointerExceptions, it is a good
		// idea to put this when we are working with Streams like this because a
		// particular element might be null.
		Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map((x) -> x * x).average().ifPresent(n -> System.out.println(n));
		System.out.println();

		// STREAMS EXAMPLE 7
		// Stream from a list, filter and print
		// Arrays.asList() method allows me to turn a list of things into a Collection
		List<String> listOfItems = Arrays.asList("Computer", "Toothpaste", "Box", "Pencil", "Car", "Tent", "Door",
				"Toy");
		// .stream() method allows me to stream a Collection of items
		// Source: "listOfItems.stream()"
		// Intermediate operation 1: ".map(x -> x.toLowerCase()) (every letter will be
		// mapped to lower case)
		// Intermediate operation 2: ".filter(x -> x.startsWith("c"))"
		// Intermediate operation 3: ".sorted()"
		// Terminal operation: ".forEach()"
		listOfItems.stream().map(x -> x.toLowerCase()).filter(x -> x.startsWith("c")).sorted()
				.forEach(x -> System.out.println(x + ", "));
		System.out.println();

		// STREAMING FILES
		// Another way to read files utilizing a Stream object
		Stream<String> lines = Files.lines(Paths.get("files/wordFile.txt"));
		// Source: "lines"
		// Intermediate operation 1: ".sorted()"
		// Intermediate operation 2: ".filter((l) -> l.length() > 6)" (only gets lines
		// with a character length over 6)
		// Terminal operation: ".forEach()"
		lines.sorted().filter((l) -> l.length() > 6).forEach(x -> System.out.println(x + ", "));
		// Always remember to do this
		lines.close();
		// A way to optimize the above code is to filter first, THEN sort, that way we
		// won't waste time sorting through words we wont use. If this was a large file,
		// sorting first might take quite a bit of time.
		System.out.println();

		// STREAMING FILES 2
		// Source: "List<String> words = Files.lines(Paths.get("files/wordFile.txt"))"
		// Intermediate operation: ".filter()"
		// Terminal operation: ".collect()" (turns a stream of items into a Collection)
		List<String> words = Files.lines(Paths.get("files/wordFile.txt")).filter(x -> x.contains("th"))
				.collect(Collectors.toList());
		// Source: "words"
		// Terminal operation: ".forEach()"
		words.forEach(x -> System.out.println(x + ", "));
		System.out.println();

		// STREAMING FILES 3
		// Source: "(int) rows"
		// Intermediate operation 1: ".map(x -> x.split(","))" (a lambda expression to
		// split the elements in the lines every time a comma is encountered, this file
		// is a .txt file but is formatted like a .csv with commas separating every
		// word/number in the lines
		// Intermediate operation 2: ".filter(x -> x.length > 3)" (Filters and only gets
		// lines that have more than 3 "entries", as we are separating by comma. This
		// .length is different than the .length() that I used in STREAMING FILES 1,
		// remember that .length() (with parenthesis) refers to the length of a string
		// (which was the word in each line in STREAMING FILES 1), and .length (with no
		// parenthesis) refers to the length of an Array (how many elements), which is
		// what is applicable here, as I split the lines by their commas (.split(",")).
		// Terminal operation: ".count()" (count returns an int, which is why we
		// declared the "rowCount" variable as an int)
		Stream<String> rows = Files.lines(Paths.get("files/stockDataCsv.txt"));
		int rowCount = (int) rows.map(x -> x.split(",")).filter(x -> x.length > 3).count();
		System.out.println(rowCount + " good rows.");
		System.out.println();
		// Make sure we close the file.
		rows.close();

		// STREAMING FILES 4
		// Source: "rows2"
		// Intermediate operation 1: ".map(x -> x.split(","))" (takes every line in the
		// file, which is a string, splits it at each comma, and turns it into an array)
		// Intermediate operation 2: ".filter(x -> Integer.parseInt(x[1].trim()) > 15)"
		// (filters by arrays where the number at index 1 is greater than 15, must
		// parseInt because after splitting the string into different elements they are
		// still text)
		// Terminal operation: ".forEach(x -> System.out.println(x[0].trim() + " " +
		// x[2].trim() + " " + x[3].trim()));" (prints out elements at index 0, 2, and 3
		// of the filtered arrays)
		Stream<String> rows2 = Files.lines(Paths.get("files/stockDataCsv.txt"));
		rows2.map(x -> x.split(",")).filter(x -> x.length > 3).filter(x -> Integer.parseInt(x[1].trim()) > 15)
				.forEach(x -> System.out.println(x[0].trim() + " " + x[2].trim() + " " + x[3].trim()));
		rows2.close();
	}

}
