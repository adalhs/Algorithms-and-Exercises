package com.jobready.lesson3_producer_consumer;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		// To avoid wasting time writing questions, we will just write questions as
		// integers, simulating question 1, 2, 3, etc. This list will be passed to both
		// the Producer and Consumer threads.
		List<Integer> questionList = new ArrayList<>();
		
		// An inter-thread communication is happening here because of the
		// Producer-Consumer design pattern with .wait() and .notify(). Both threads are
		// sharing the same resource.
		// NOTE: HOWEVER, .wait() and notify() are still primitive ways of handling
		// concurrency and we should be utilizing the concurrent data structures that
		// java provides (like CopyOnWriteArrayList, and Blocking Queue for example).
		Thread t1 = new Thread(new Producer(questionList));
		Thread t2 = new Thread(new Consumer(questionList));

		t1.start();
		t2.start();
	}

}