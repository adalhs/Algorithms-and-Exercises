package com.jobready.anonymous_classes;

public class AnonymousClasses {

	public static void main(String[] args) {

		// AN ANONYMOUS CLASS is a class with no name that is used to instantiate
		// one object. Take the following example…
		Animal myAnimal = new Animal();
		myAnimal.makeNoise();

		Animal bigfoot = new Animal() {
			public void makeNoise() {
				System.out.println("RAWWWR!!");
			}
		};
		bigfoot.makeNoise();

		/*
		 * …this different than creating a bigfoot class, extending Animal to it, and
		 * overriding the makeNoise() method by specifying a new one in the bigfoot
		 * class. Here, I am doing the same thing but without the need to create a
		 * bigfoot class, almost saying that bigfoot is a “subclass” of Animal but
		 * without the need to actually create a new Bigfoot class with a different
		 * makeNoise() method. That is why it is called an “anonymous class”. This is
		 * good if I will only be using it once and the class will have only one or few
		 * methods AND IF IT WILL ONLY BE USED ONCE.
		 * 
		 * Another way to create an anonymous class is by implementing an interface…
		 */

		Runnable myAnonymousRunnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("I'm an anonymous runnable");
			}
		};
		myAnonymousRunnable.run();
		// …this is different than creating a new class that implements the Runnable
		// interface and its run() method. Here, I am automatically creating and
		// instantiating a variable without the need for all that.

		// Here is an example that is used quite a bit when creating and running a
		// thread. If I didn't use an anonymous class, I would have to create a class
		// that implements the Runnable interface, then pass that in as an argument. It
		// eliminates the need to create that class.
		Thread testThread = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println(i);
				}
			}
		});
		testThread.start();
	}
}