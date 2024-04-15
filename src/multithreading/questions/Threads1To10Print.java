package multithreading.questions;


public class Threads1To10Print {

	private volatile Integer count = 1;

	private final Object object = new Object();

	public static void main(String[] args) {

		Threads1To10Print testClass = new Threads1To10Print();
		Thread t1 = new Thread(testClass.new Printer(1));
		Thread t2 = new Thread(testClass.new Printer(2));
		Thread t3 = new Thread(testClass.new Printer(3));

		t1.start();
		t2.start();
		t3.start();
	}

	class Printer implements Runnable {

		private int threadId;

		public Printer(int threadId) {
			super();
			this.threadId = threadId;
		}

		@Override
		public void run() {
			try {
				while (count <= 20) {
					synchronized (object) {
						if (count % 3 != threadId % 3) {
							object.wait();
						} else {
							System.out.println("Thread " + threadId + " printed " + count);
							count += 1;
							object.notifyAll();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
