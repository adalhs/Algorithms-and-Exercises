package verifiers;

import java.util.Scanner;

public class Verifier {

	public static int checkYesOrNo(Scanner scanner) {
		int tries = 0;
		int yesOrNo = 0;

		while (tries < 3) {
			// If the scanner hasn't received any input from the user, requests that input
			// and verifies if it is an int. If the user has previously entered an input
			// into the scanner, it verifies if that last input is an int.
			if (scanner.hasNextInt()) {
				// Assigns user input to variable
				yesOrNo = scanner.nextInt();

				// Checks that the user entered a valid input (1 or 2)
				if (yesOrNo > 2 || yesOrNo < 1) {
					tries++;
					if (tries == 3) {
						exitProgram();
					}
					System.out.println("That is not a valid input, please try again.");

					// If input is a number, and it is 1 or 2, returns that value
				} else {
					return yesOrNo;
				}
				// If input is not a number
			} else {
				tries++;
				if (tries == 3) {
					exitProgram();
				}
				System.out.println("The input must be a number, please try again.");

				// Consuming the "\n" left over at the end when the scanner reads the "int"
				// input, as nextInt() will only read the numbers in the line and leave the "\n"
				// in the scanner. If I don't do this, when it next goes to nextInt() it will
				// retrieve nothing, as the scanner will still have \n left over at the end and
				// that contains no integers
				scanner.next();
			}
		}

		// Returns value 1 for YES or 2 for NO
		return yesOrNo;
	}

	private static void exitProgram() {
		System.out.println("Locking system...");
		System.exit(0);
	}
}