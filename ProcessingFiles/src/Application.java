import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.imtiaz.exceptions.PracticeException1;

public class Application {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter some text: ");
		String enteredText = input.nextLine();
		System.out.println(enteredText);
		input.close();

		
		try {
			File file = new File("myfile.txt");
			Scanner input2 = new Scanner(file);
			
			while (input2.hasNextLine()) {
				String line = input2.nextLine();
				System.out.println(line);
			}
			input2.close();
			
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("File not found");
		}
		
		//The exception I created in case the number passed is less than 10.
		try {
			System.out.println(PracticeException1.subtract10FromLargerNumber(9));
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("The number passed is smaller than 10.");
		}
		
	}

}
