package com.jobready.lesson3_producer_consumer;

import java.util.List;

public class Producer implements Runnable {
	/*
	 * Producer thread will add questions to the List until a limit of 5 is reached,
	 * then will wait (.wait()) until the Consumer thread answers the questions.
	 * Then Producer thread will be notified (.notify()) that it can add more
	 * questions to the List
	 */
	private int questionNo;
	// final means it cannot be changed
	final int LIMIT = 5;

	List<Integer> questionList = null;

	public Producer(List<Integer> questionList) {
		this.questionList = questionList;
	}

	/*
	 * Throws instead of a try/catch for handling exceptions means that I will
	 * handle the exception elsewhere if it does happen. I always need to address it
	 * with a try/catch block, and if I don't, I need to throw it so that it can be
	 * handled somewhere else if it does occur
	 */
	public void readQuestion(int questionNo) throws InterruptedException {
		/*
		 * The synchronized (shared) object is questionList. This ensures that when
		 * Producer thread accesses "questionList", it will "lock it down" so no other
		 * thread can access it, and will not release the lock until it completes the
		 * code inside the synchronized block. We can also "synchronize (this)" if we
		 * want to synchronize the whole instance of a class.
		 */
		synchronized (questionList) {
			while (questionList.size() == LIMIT) {
				System.out.println("Questions have piled up... wait for answers");
				/*
				 * While the LIMIT == 5, this will tell the Producer thread it should no longer
				 * try to access the questionList resource until it is notified (with .notify()
				 * or .notifyAll()) that it can access that resource again. We are waiting for
				 * the Consumer thread to answer some questions before populating the questList
				 * with more questions.
				 */
				questionList.wait();
			}
		}

		synchronized (questionList) {
			System.out.println("New question: " + questionNo);
			questionList.add(questionNo);

			// Adding a short Thread.sleep() so that questions aren't added so quickly one
			// after the other, just makes the program more realistic.
			Thread.sleep(100);

			/*
			 * This makes the Producer thread relinquish the "lock" it has on the
			 * "questionList" resource and notifies other threads that may have been put to
			 * .wait() to use it that they can now do so.
			 */
			questionList.notify();
			// NOTE 1: The fact it is relinquishing the "lock", doesn't mean the same
			// thread can't grab a hold of the object once more, it just lets others know
			// they can now access it. That is why we put the .wait() in the synchronized
			// code above this one, so that when the LIMIT of 5 questions is reached, this
			// thread definitely does not use that resource again.
			// NOTE 2: .notify() randomly selects one thread that may be waiting to use a
			// resource that it can now use it.
			// NOTE 3: .notifyAll() notifies all the threads that may be waiting to use the
			// resource that they can now use it
			// NOTE 4: .wait(), .notify(), and .notifyAll() can only be used inside a
			// synchronized block.
		}
	}

	@Override
	public void run() {
		// while (true) allows our thread to continue to run until we close the program.
		// The Producer thread will continue to add questions to the questionList to be
		// answered by the Consumer thread.
		while (true) {
			try {
				// Will increment questionNo after it finishes running the method
				readQuestion(questionNo++);
			} catch (InterruptedException e) {

			}
		}
	}
}
