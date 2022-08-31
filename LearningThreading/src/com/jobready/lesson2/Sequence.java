package com.jobready.lesson2;

public class Sequence {

	private int value = 0;

	/*
	 * This method is not thread-safe. If we have more than one thread accessing
	 * this method, we would think the first thread is going to increment the value
	 * from 0 to 1, and then the next thread will see that value is 1, and increment
	 * it to two, the next thread will see that the value is 3 and increment it to
	 * 4, and so on and so forth, but this is not how it works.
	 */
	public int getNext() {
		// value++ here is really three steps (value = value + 1), the way the processor
		// handles multiple threads is, it gives control to one, then tells it to stop
		// once it has done a bit of work, then it gives control to another, then tells
		// it to stop and it gives control to another, and so on and so forth. The
		// reason why we get some duplicates is because the processor might tell thread
		// A to stop once it has assigned a value to the "value" variable, then it might
		// give control to thread B and thread B will read that the "value" variable has
		// "3" in it, so it adds 1 and returns 4, then it gives BACK control to thread
		// B, (which is still holding that "value" = 3), it adds 1 and makes returns
		// that value is ALSO 4, so we can get duplicates

		// we can solve this with "automicity" or "all or nothing", specifying that we
		// want the whole line of code to complete, not just parts of it. It basically
		// means: "either do ALL of this, or don't do it at all". For this we can use
		// the keyword "synchronized" and enclose the code to be synchronized in its
		// brackets. (We have to specify the object that is synchronized, so we pass in
		// the keyword "this" as an argument

		// The way this works is that the thread that gets to a synchronized block
		// "locks" the code, so no other thread can touch it until it's done with it.
		// It's important to also enclose the return, so that the next thread can read
		// the correct value when it invokes the getNext() method.
		synchronized (this) {
			value++;
			return value;
		}
		// I can also synchronize the whole method by putting the synchronized keyword
		// in the method signature, i.e.: public synchronized int getNext()

		// NOTE: Even though we will not see repeated numbers, we might still get a few
		// numbers out of order, because while the get.Next() method is synchronized,
		// the sysout statement that prints the numbers back in the Thread class
		// definition in main method is not. In this particular scenario, what we could
		// do to prevent that is to put the sysout statement inside this synchronized
		// block (or method) as well
	}

}
