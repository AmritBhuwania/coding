package multithreading.synchronisation;

public class SynchronizationCustomLocks {

    public static int counter1 = 0;
    public static int counter2 = 0;
    
    private static final Object lock1 = new Object();

    private static final Object lock2 = new Object();

    public static void increment1() {
        synchronized (lock1) {
            counter1 ++; 
        }        
    }

    public static void increment2() {
        synchronized (lock2) {
            counter1 ++;
        }
    }

    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100 ; i++) increment1();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100 ; i++) increment2();
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

        System.out.println("Counter 1 is " + counter1);
        System.out.println("Counter 2 is " + counter1);
    }
    public static void main(String[] args) {
        process();
        /**
         * Problem - Problem with synchronisation is that each class/object has only one intrinsic lock
         *          * If we have 2 independent synchronized methods each thread must wait for the other to release the lock.
         *          * In the above case we have two independent synchronized methods
         *          * However if t1 calls increment1() it acquires the intrinsic lock for the class
         *          * SO even though t2 needs to call increment2() a completely independent method, it will have to wait for
         *          * t1 to relinquish the lock. As a result the application would be slower
         * Solution - Use custom locks         
         */

        /**
         * Ok so a thread cannot acquire a lock owned by another thread. 
         * But a given thread can acquire a lock that it already owns.
         * Allowing a thread to acquire the same lock more than once is called re-entrant synchronization
         For example: let's consider recursive method calls. 
         If a given thread calls a recursive and synchronized method several times,
         then it is fine (note that in this case the same thread "enters" the synchronized block
         several times). There will be no deadlock because of re-entrant synchronization.
         */
        

    }
}
