package com.jobready.lesson3_producer_consumer;

import java.util.List;

public class Consumer implements Runnable {
	/*
	 * Consumer thread will read questions from the List until there are none, then
	 * will wait (.wait()) until the Producer thread adds more questions to the
	 * List. Then Producer thread will be notified (.notify()) that it can add more
	 * questions to the List
	 */

	List<Integer> questionList = null;

	public Consumer(List<Integer> questionList) {
		this.questionList = questionList;
	}

	// Throws instead of a try/catch for handling exceptions means that I will
	// handle the exception elsewhere if it does happen. I always need to address it
	// with a try/catch block, and if I don't, I need to throw it so that it can be
	// handled somewhere else if it does occur
	public void answerQuestion() throws InterruptedException {
		/*
		 * The synchronized (shared) object is questionList. This ensures that when
		 * Consumer thread accesses "questionList", it will "lock it down" so no other
		 * thread can access it, and will not release the lock until it completes the
		 * code inside the synchronized block. We can also "synchronize (this)" if we
		 * want to synchronize the whole instance of a class.
		 */
		synchronized (questionList) {
			while (questionList.isEmpty()) {
				System.out.println("No questions to answer... waiting for producer to get questions");

				/*
				 * While the questionList is empty, the Consumer thread will .wait() for the //
				 * Producer thread to add another question to it, at which point the Producer //
				 * thread sends a .notify(), letting the Consumer thread know questionList is no
				 * // longer "locked".
				 */
				questionList.wait();
			}
		}

		synchronized (questionList) {
			// It takes longer to answer questions than to ask them, so to make this program
			// more realistic, I am setting up a 5 second sleep.
			Thread.sleep(5000);

			// The remove() method from Lists not only removes an item, but also returns it,
			// which allows us to print it. We will always answer the first question in the
			// List (0 index) first, kind of like a queue.
			System.out.println("Answered question: " + questionList.remove(0));

			/*
			 * This makes the Consumer thread relinquish the "lock" it has on the
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
		// The Consumer thread will continue to answer questions in the questionsList as
		// long as the Producer thread has added a question to it.
		while (true) {
			try {
				answerQuestion();
			} catch (InterruptedException e) {

			}
		}
	}
}
