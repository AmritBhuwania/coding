package multithreading.synchronisation;

public class Basic {
    
    public static int counter = 0;
    // So we created 3 threads all of which will try to increment the counter variable
    public static void process() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter ++;
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    counter ++;
                }
            }
        });
        
        Thread t3 = new Thread(() -> {
        	for (int i = 0; i < 100; i++) {
                counter ++;
            }
        });
        
        t1.start();
        t2.start();
        t3.start();
        
		/*
		 * t1.join(); t2.join(); t3.join();
		 */
        System.out.println("Counter is " + counter);
    }
    
    public static void main(String[] args) throws InterruptedException {
        process();
    }
}
/**
 * Ideally the value of counter should be 200
 * However we must note that though the operation counter ++ may seem atomic, it
 * takes some time to increment the value. This means that while the update operation
 * may still be running the other thread may access the original counter value.
 * Eg lets say current value is 100, t1 tries to update it to 101 but it takes some time,
 * meanwhile t2 also accessed it but it accesses the original value 100 and not the update value 101
 * This causes both threads to update the value to 101.
 */