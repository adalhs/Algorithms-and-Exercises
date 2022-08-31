package lesson3;

import java.util.Objects;

public class Animal {
	
	String name;
	int age;
	
	public Animal(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}

	public int hashCode() {
		return Objects.hash(age, name);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	
	
}
