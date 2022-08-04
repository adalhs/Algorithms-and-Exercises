
public class CashOnHandVerifier extends Verifier {

	public static void verifyCashOnHand(Customer cust) {
		System.out.println("\nExcellent, now you said you have $" + cust.cashOnHand
				+ " for a down payment, is this correct?\n\nType 1 for 'YES' and 2 for 'NO'");

		// Checks user has entered a valid input
		if (checkYesOrNo() == 2) {
			System.out.println("I'm sorry, let me correct that for you, please enter the amount of your down payment.");

			double downPayment;
			int tries = 0;

			while (tries < 3) {
				
				// If the scanner hasn't received any input from the user, requests that input
				// and verifies if it is a double. If the user has previously entered an input
				// into the scanner, it verifies if that last input is a double.
				if (scanner.hasNextDouble()) {
					
					downPayment = scanner.nextDouble();
					scanner.close();
					cust.setCashOnHand(downPayment);
					
					//Leaving method, otherwise can continue running while loop in cases
					return;
					
				} else {
					tries++;
					//If user has entered wrong information 3 times, program exits
					if (tries == 3) {
						System.out.println("Locking system...");
						System.exit(0);
					}
					scanner.next();
					System.out.println("Please enter only numbers for your down payment.");
				}
			}
		}
	}
}
