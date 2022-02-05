package multithreading.synchronisation;

public class Synchronisation {

    public static int counter = 0;
    // synchronised ensures that only one thread can access this method at any point of time.
    // This helps us overcome the problems encountered in the previous case when multiple threads were accessing the value
    public static synchronized void increment() {
        counter ++;
    }
    // So we created 2 threads both of which will try to increment the counter variable
    // What we can do is add the synchronised keyword to a method
    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100 ; i++) increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100 ; i++) increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Counter is " + counter);
    }
    public static void main(String[] args) {
        process();
        /**
         * Internally all java objects and classes have an internal lock called the monitor/intrinsic lock
         * Because of this lock no two threads can access a synchronized method at the same time
         * So when one thread(t1) enters a synchronized method it acquires the intrinsic lock for that class
         * So the other thread(t2) needs to wait for t1 to release the lock.
         * As soon as t1 finishes execution it relinquishes control of the lock.
         */
    }
}
