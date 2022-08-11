package client;

import inventory.InventoryManager;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		InventoryManager manager = new InventoryManager();

		Thread populateSoldTask = new Thread(new Runnable() {
			@Override
			public void run() {
				manager.populateSoldProducts();
			}
		});

		Thread displaySoldTask = new Thread(new Runnable() {
			@Override
			public void run() {
				manager.displaySoldProducts();
			}
		});

		// Because threads take a moment to start, the "displaySoldTask" thread might
		// begin reading from the "soldProductsList" List before the "populateSoldTask"
		// thread has had a chance to add any data to it. So, to give the
		// "displaySoldStack" thread some time to populate data into the list, we will
		// implement a Thread.sleep() for 2 seconds.
		populateSoldTask.start();
		Thread.sleep(2000);
		displaySoldTask.start();
	}
}
