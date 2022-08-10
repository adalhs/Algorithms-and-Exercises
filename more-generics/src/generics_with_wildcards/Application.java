package generics_with_wildcards;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {
		/*
		 * Remember that everything in Java is an object. Every class and method is a
		 * child of the Object class. For this reason, declaring an Object type
		 * variable, and assigning it the value of a String variable is valid, since the
		 * String class is a child of the Object class.
		 */
		Object myObject = new Object();
		String myVar = "Hello";
		myObject = myVar;

		/*
		 * The same logic can be applied here, Accountant is a child of the Employee
		 * class, so I can assign "acc"; an Accountant object, to be the same as "emp",
		 * an Employee object
		 */
		Employee emp = new Employee();
		Accountant acc = new Accountant();
		emp = acc;

		/*
		 * However, this same logic does not apply to Generics. I can't say that a list
		 * of employees is the same as a list of accountants. Because the class
		 * "ArrayList<Accountant>" isn't a child of the class "ArrayList"<Employee>".
		 */
		ArrayList<Employee> employees = new ArrayList<>();
		ArrayList<Accountant> accountants = new ArrayList<>();
		// Commenting this out so it runs
		// employees = accountants;

		/*
		 * When we assign a wildcard "?" as the type of data for a generic, then we can
		 * say that a list of accountants is the child of a list of "?". It will treat
		 * it like its a list of Objects, so we are almost using it the same way as if
		 * using a raw type. Although we know that a list of accountants being a child
		 * of a list of "?" is not useful this works. However, it is more useful if we
		 * do something like what is below...
		 */
		ArrayList<?> employees2 = new ArrayList<>();
		ArrayList<String> accountants2 = new ArrayList<>();
		employees2 = accountants2;

		/*
		 * ...If I do something like what is below, then the wildcard will take the
		 * place of the child(ren) of the class I am extending. This makes * it so that
		 * now, ALL children of the Employee class, as well as the * Employee class
		 * itself, can also go in the list.
		 * 
		 * This is more useful as we have to write "extends Class" and this lets * us
		 * see WHAT we must be a child of, instead of just writing "?" like * the above
		 * example, where it just treats is as “Object”, meaning: “this is a List of
		 * Object Class and any child(ren) of it, but we know that that includes
		 * everything, as everything is an child of, and by essence, an Object in Java,
		 * so we could literally put anything in that List and it’s not helpful.
		 * 
		 * Since using “extends” means that Employee class, as well as any of its
		 * children can also go in the list, in this sense, "extends" means
		 * "upper bound" or "the class and any under it can go in".
		 * 
		 * If Employee was an interface instead of a class, I would write "implements"
		 * instead of "extends" in the Accountant class (and "interface" instead of
		 * "class" in the Employee class. (We also wouldn't instantiate an Employee
		 * object above like we did. We would keep "extends" in the List.)
		 */

		ArrayList<? extends Employee> employees3 = new ArrayList<>();
		ArrayList<Accountant> accountants3 = new ArrayList<>();
		employees3 = accountants3;

		/*
		 * AFTER EXTENDING A CLASS TO "?", I can't just put any data type in the
		 * ArrayList of accountants, <String> won't work like the example above. We MUST
		 * specify now that the ArrayList contains Employee data type. This will not
		 * work when I extend a class to the wildcard ("?") ArrayList<String>
		 * accountants3 = new ArrayList<>(); employees3 = accountants3;
		 */

		/*
		 * Another thing we can do is make it so that only parents of the class (or the
		 * class itself) can be added into the list, so it is the opposite of what we
		 * did above. For this, I must use the "super" keyword. Here, I can put Object
		 * as the type of data in accountants4 and I will be able to do that because the
		 * only parent of Employee is Object. On the contrary I will not be able to put
		 * "Accountant" as the data type, as Accountant is not a parent of Employee. In
		 * this sense, "super" means "lower bound" or
		 * "the class and any above it can go in".
		 */
		ArrayList<? super Employee> employees4 = new ArrayList<>();
		ArrayList<Object> accountants4 = new ArrayList<>();
		employees4 = accountants4;

		employees.add(new Employee());
		accountants.add(new Accountant());
		makeEmployeesWork(employees);

		/*
		 * This will not work unless I add the "? extends" to the method below, because
		 * remember: by default, a List of Employees is not the same as a list of
		 * accountants, only the wildcard lets me add children of the class to a list.
		 */
		makeEmployeesWork(accountants);

	}

	public static void makeEmployeesWork(List<? extends Employee> employees) {
		for (Employee e : employees) {
			e.work();
		}
		/*
		 * If I delete the work() method from the Employee class, this will not work,
		 * because even though the Accountant class has a work() method, the data type I
		 * am passing in "for(Employee e : employees)" is Employee, and methods always
		 * go by the data type that is passed in.
		 * 
		 * 
		 * Even if I were to pass Accountant; which does still have a work() * method,
		 * it still won’t work because of the wildcard. See, the * wildcard means I am
		 * passing "Employee and children of Employee", but * the wild card (?) doesn't
		 * know which children, it just knows that * children are accepted, but it won't
		 * know if the children have a * work() method or not. So this is a limitation
		 * when using wildcards. * The only way to do this would be by DOWNCASTING and
		 * letting the * compiler know that it should look for that method specifically
		 * in the * child I am passing in, like so:
		 * 
		 * for(Accountant e : (ArrayList<Accountant>) employees).
		 *
		 * However, this practice of up or downcasting is DISCOURAGED UNLESS * EXTREMELY
		 * NEEDED, as it will ignore the type-safety of Java.
		 */

	}

}
