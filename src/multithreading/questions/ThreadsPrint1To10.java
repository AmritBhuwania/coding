package multithreading.questions;


public class ThreadsPrint1To10 {

	private volatile Integer count = 1;
	private Integer threadIdToRun = 1;

	private Object object = new Object();

	public static void main(String[] args) {

		ThreadsPrint1To10 testClass = new ThreadsPrint1To10();
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
						if (threadId != threadIdToRun) {
							object.wait();
						} else {
							System.out.println("Thread " + threadId + " printed " + count);
							count += 1;

							if (threadId == 1)
								threadIdToRun = 2;
							else if (threadId == 2)
								threadIdToRun = 3;
							else if (threadId == 3)
								threadIdToRun = 1;

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

