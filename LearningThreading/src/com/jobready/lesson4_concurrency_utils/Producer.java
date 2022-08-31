package com.jobready.lesson4_concurrency_utils;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	int questionNo;
	BlockingQueue<Integer> questionQueue;

	public Producer(BlockingQueue<Integer> questionQueue) {
		this.questionQueue = questionQueue;
	}

	@Override
	public void run() {

		// This is three steps, and we know from previous lessons that another thread
		// can come and do other things while the one managing this stops mid-way.
		// However, in this case it is ok because the ony thread that can access this is
		// the Producer thread. If we had more than one Producer thread then it could be
		// a problem and we would need to surround it in a synchronized block. Say, if
		// we had a print statement after incrementing the questionNo, we would want all
		// of that; the incrementing and the printing, inside a synchronized block.

		// questionNo++;

		while (true) {
			try {
				// questionQueue.put(questionNo); // could also do questionNo++ here and not do
				// it above
				questionQueue.put(getNextQuestion()); // best way to do it, as we are printing something along with the
														// incrementing and we want that to be synchronized
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// Synchronized everything happens all or nothing. Still not 100% thread-safe
	// though, and it has to do with the questionQueue.put() above. This whole
	// getNextQuestion() method is thread-safe, however, after the method returns
	// its value, there may be a pause on the thread before it .put() actually gets
	// executed and adds that value to the questionQueue.

	// While we could also surround the.put() method above in a synchronized block,
	// this is not a good idea, because we would have a synchronized block inside
	// another synchronized block. This slows down programs considerably and is a
	// big red flag. The best thing to do in this case would be to GET RID OF this
	// getNextQuestion() method entirely, and just use a synchronized block above
	// and enclose the incrementation of questionNo, the .put(), and the sysout in
	// it.
	private synchronized int getNextQuestion() {
		int nextQuestion = questionNo++;
		System.out.println("Got new question: " + nextQuestion);
		return nextQuestion;
	}

}
