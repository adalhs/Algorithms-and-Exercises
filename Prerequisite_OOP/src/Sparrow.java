
public class Sparrow extends Bird implements Flyable{

	public Sparrow(int age, int weightInPounds, int heightInInches, String species) {
		super(age, weightInPounds, heightInInches, species);
	}

	public void fly() {
		System.out.println("Sparrow flying high...");
	}

}
