package inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryManager {

	// The CopyOnWriteArrayList is part of java.util.concurrent, and it behaves like
	// an ArrayList but it allows "concurrency" or various threads accessing it at
	// the same time
	List<Product> soldProductsList = new CopyOnWriteArrayList<>();

	List<Product> purchasedProductsList = new ArrayList<>();

	public void populateSoldProducts() {
		for (int i = 0; i < 1000; i++) {
			Product prod = new Product(i, "test_product_" + i);
			soldProductsList.add(prod);
			System.out.println("ADDED: " + prod);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void displaySoldProducts() {
		for (Product product : soldProductsList) {
			System.out.println("PRINTING THE SOLD: " + product);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
