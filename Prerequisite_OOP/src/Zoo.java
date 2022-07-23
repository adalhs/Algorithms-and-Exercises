
public class Zoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Animal animal1 = new Animal(3, 24, 14, "bear");
		//Animal animal2 = new Animal(4, 54, 67, "monkey");
		
		Animal fish1 = new Fish(1, 2, 8, "fish");
		//Chicken chick1 = new Chicken(4, 6, 8, "chicken");
		
		//animal1.eat();
		//animal2.walk();
		//fish1.swim();
		fish1.sleep();
		
		
		//chick1.fly();
		
		Animal sparrow1 = new Sparrow(3, 7, 12, "sparrow");
		//sparrow1.fly();
		//sparrow1.move();
		
		moveAnimal(sparrow1);
		moveAnimal(fish1);
	}
	
	public static void moveAnimal(Animal animal) {
		animal.move();
	}

}
