package someotherpackage;

//imports class from other package to be able to use its methods,
//only possible if the class to be imported is set to public
//(public class <class name>), instead of private (class <class name>)
import java_basics.MyUtils;

public class ExampleClass {

	public static void doSomething() {
		MyUtils.printSomeJunk(87);
	}

}
