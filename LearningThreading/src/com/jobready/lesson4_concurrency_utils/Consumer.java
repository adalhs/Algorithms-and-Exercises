package com.jobready.lesson4_concurrency_utils;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	BlockingQueue<Integer> questionQueue;

	public Consumer(BlockingQueue<Integer> questionQueue) {
		this.questionQueue = questionQueue;
	}

	@Override
	public void run() {
		while (true) {
			try { // .take() retrieves AND REMOVES the head of the queue, and waits for next if
					// necessary
				System.out.println("ANSWERED QUESTION: " + questionQueue.take());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
