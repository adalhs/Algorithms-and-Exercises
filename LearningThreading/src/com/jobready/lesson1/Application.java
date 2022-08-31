package com.jobready.lesson1;

public class Application {

	public static void main(String[] args) {
		// We don't directly call the run() method of a Thread, we use the .start()
		// method that belongs to the Thread class to execute what is in their run().
		// The Thread class gets its run() method because it implements the Runnable
		// interface which has that method in it.

		// Threads cannot be run more than once, if I want to run the code in it again,
		// I must create another instance of it. All threads will be running at the same
		// time. The ones I .start() first will begin running first.

		// Running an instance of class Task, which extends Thread class
		System.out.println("Starting Thread 1");
		Task taskRunner = new Task("Thread A");
		taskRunner.start();

		// Running another instance of class Task, which extends Thread class
		System.out.println("Starting Thread 2");
		Task taskRunner2 = new Task("Thread B");
		taskRunner2.start();

		// ********************************************************
		// Making a class that implements the runnable interface is preferable to
		// creating classes that extend Thread...
		// Running an instance of class TestThread, which implements Runnable interface
		System.out.println("Starting Thread 3");
		SecondTask taskRunner3 = new SecondTask("Thread C");
		Thread thread3 = new Thread(taskRunner3);
		thread3.start();

		// Another way of running an instance class TestThread, which implements
		// Runnable interface
		System.out.println("Starting Thread 4");
		Thread thread4 = new Thread(new SecondTask("Thread D"));
		thread4.start();

		/*
		 * Another way of running an instance is by doing it the "anonymous class" way.
		 * An anonymous class is a class with no name that is used to instantiate an
		 * object. Here I am using an interface, and not a class, but the same principle
		 * applies. In this example, I am using it to implement an interface with just
		 * one method (run()). This way I don't need to make a separate class with the
		 * code of the run() method. This can be useful in cases where I need to use the
		 * code only once, so that it is close to where it is being used. If the code is
		 * repeated even once, then it makes no sense to do it this way, or if the
		 * interface or code I'm trying to use is long or has many methods. In those
		 * cases, a separate class with the code should be implemented. In this case, I
		 * am not specifying any class to be used to get the run() method from, like in
		 * the previous threads.
		 */
		Thread thread5 = new Thread(new Runnable() {
			String name = "Thread E";

			public void run() {
				for (int i = 0; i < 1000; i++) {
					System.out.println(this.name + " - Number: " + i);

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread5.start();
	}
}

//Creating a Task class that is a child of Thread class
class Task extends Thread {

	// So that it is easier to see what Thread is doing what
	String name;

	public Task(String name) {
		this.name = name;
	}

	public void run() {
		// I could just do "this.name" in the sysout with no need to do this setName()
		Thread.currentThread().setName(name);

		for (int i = 0; i < 1000; i++) {

			// Getting name of the thread before printing out the number so it is more clear
			// to understand what thread is doing what. This will return the default thread
			// name if no specific name is given.
			System.out.println(Thread.currentThread().getName() + " - Number: " + i);

			// Using sleep() method of the Thread class to slow down the thread by 500ms. It
			// will ask me to put this inside a try/catch because the sleep() method throws
			// an interrupted exception (can check this by ctrl-clicking sleep() method)
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

//Creating a SecondTask class that implements the Runnable interface
class SecondTask implements Runnable {
	String name;

	public SecondTask(String name) {
		this.name = name;
	}

	public void run() {

		// I could just do "this.name" in the sysout with no need to do this setName()
		Thread.currentThread().setName(name);
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName() + " - Number: " + i);

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
