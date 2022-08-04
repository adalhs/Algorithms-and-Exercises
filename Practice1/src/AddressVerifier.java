
public class AddressVerifier extends Verifier {

	public static void verifyAddress(Customer cust) {
		System.out.println("First, I have for your address " + cust.address
				+ ", is this correct?\n\nType 1 for 'YES' and 2 for 'NO'");

		// Checks user has entered a valid input
		if (checkYesOrNo() == 2) {
			System.out.println("I'm sorry, let me correct that for you, please type your new address here.");
			scanner.nextLine();
			//String add = scanner.nextLine();
			//System.out.println(scanner.nextLine());
			// Will get user's input as a String and pass that to setAddress() method
			cust.setAddress(scanner.nextLine());
		}
	}
}
