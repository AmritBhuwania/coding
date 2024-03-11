package multithreading.synchronisation;

public class SynchronisationProblems {

    public static int counter1 = 0;
    public static int counter2 = 0;
     
    // This is called class level locking
    public static synchronized void increment1() {
        counter1 ++;
    }

    public static synchronized void increment2() {
        counter2 ++;
    }
    
    // if we have a method like this
    public void sampleMethod() {
        // We could do something like this
        synchronized (this) {
            // this is called object level locking, we acquire the lock associated with the object
            // these are called synchronized blocks
        }
    }

    // if we have a method like this
    public static void sampleMethod2() {
        // We could do something like this if we are dealing with static 
        synchronized (SynchronisationProblems.class) {
            // this is called class level locking, we acquire the lock associated with the object
            // these are called synchronized blocks
            counter1 ++;
            
            // This is a better way to write synchronized
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
        /**
         * Problem with synchronisation is that each class/object has only one intrinsic lock
         * If we have 2 independent synchronized methods each thread must wait for the other to release the lock.
         * In the above case we have two independent synchronized methods
         * However if t1 calls increment1() it acquires the intrinsic lock for the class
         * SO even though t2 needs to call increment2() a completely independent method, it will have to wait for
         * t1 to relinquish the lock. As a result the application would be slower
         */

        new SynchronisationProblems().sampleMethod();
    }
}
