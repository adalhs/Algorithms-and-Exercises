package lesson2;

public class Application {

	public static void main(String[] args) {

		Sequence sequence = new Sequence();

		Worker worker1 = new Worker(sequence);
		Worker worker2 = new Worker(sequence);

		worker1.start();
		worker2.start();
	}
}

class Worker extends Thread {
	// Null when object is initialized unless we use the constructor
	Sequence sequence = null;

	// Creating constructor with Sequence object as an argument
	public Worker(Sequence sequence) {
		// the sequence variable will be equal to the sequence argument that is passed
		// in when we call the constructor
		this.sequence = sequence;
	}

	public void run() {
		for (int i = 0; i < 100; i++) {
			// Getting name of the thread and value it has from sequence getNext() method
			System.out.println(Thread.currentThread().getName() + " got value: " + sequence.getNext());
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
