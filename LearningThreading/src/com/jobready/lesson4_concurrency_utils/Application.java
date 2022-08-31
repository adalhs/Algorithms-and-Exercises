package com.jobready.lesson4_concurrency_utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {

	public static void main(String[] args) {

		// Array blocking queue expects an int argument representing the capacity
		// or LIMIT of the data held in it. We don't have to do like lesson 3 of this
		// package where we had to manage it with if/else/while loops. In this case, the
		// capacity is being set to 5. This removes the need for so much .wait() and
		// .notify().
		BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<>(5);
		Thread t1 = new Thread(new Producer(questionQueue));
		Thread t2 = new Thread(new Consumer(questionQueue));
		
		t1.start();
		t2.start();
	}
}
