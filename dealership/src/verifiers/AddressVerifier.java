package verifiers;

import java.util.Scanner;

import dealership.Customer;


public class AddressVerifier extends Verifier {

	public static void verifyAddress(Customer cust, Scanner scanner) {
		System.out.println("First, I have for your address " + cust.getAddress()
				+ ", is this correct?\nType 1 for 'YES' and 2 for 'NO'");

		// Checks user has entered a valid input
		if (checkYesOrNo(scanner) == 2) {
			System.out.println("I'm sorry, let me correct that for you, please type your new address here.");

			// Consuming the "\n" left over from when we used nextInt() to get the numbers
			// in the user's input in the checkYesOrNo() method
			scanner.nextLine();

			// Will get the line of user's input as a String and pass that to setAddress()
			cust.setAddress(scanner.nextLine());
		}
	}
}