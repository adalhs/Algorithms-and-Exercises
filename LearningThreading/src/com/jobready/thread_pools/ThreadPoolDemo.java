package com.jobready.thread_pools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		// The ExecutorService is what manages thread pools. There are different thread
		// pools that can be created, but for this example I'm using the
		// FixedThreadPool. The number two means that we want this thread pool to manage
		// two threads. We don't tell it which thread will do what though, just that it
		// can use two threads to get the work done. We don't have to concern ourselves
		// with the lower level processes.
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// Passing in number "4" as the message. I'm using numbers as an example,
		// instead of writing sentences.
		// The ExecutorService will use either thread 1 or thread 2, whichever is
		// available first, to execute these 4 tasks.
		Runnable processor = new MessageProcessor(4);
		executor.execute(processor);

		Runnable processor2 = new MessageProcessor(10);
		executor.execute(processor2);

		Runnable processor3 = new MessageProcessor(7);
		executor.execute(processor3);

		Runnable processor4 = new MessageProcessor(12);
		executor.execute(processor4);

		// The ExecutorService will keep running because it will await more tasks unless
		// we run this method, which rejects any new tasks from being submitted. It will
		// wait for current tasks to finish.
		executor.shutdown();
		// There's also a method called .shutdownNow(), which does not wait for current
		// tasks to finish, shutting down the executor in a less graceful manner.

		// If we don't use the while loop, the sysout will run before the tasks above
		// are finished, because this is run by the main thread. We can use the while
		// loop above, which is also run by the main thread, to "lock" the main thread
		// in that loop while the executor is not terminated. Then, once the executor
		// terminates, the main thread will exit that loop and go to the sysout.
		while (!executor.isTerminated()) {

		}
		System.out.println("Submitted all tasks...");
	}
}
