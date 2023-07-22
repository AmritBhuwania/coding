package multithreading.synchronisation;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Processor {
    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void  Producer() throws InterruptedException {
        lock.lock();
        System.out.println("Producer");
        // similar to wait
        condition.await();
        System.out.println("Producer again");
        // unlock as many times as you lock
        /**
         * Consider an operation which requires exception handling
         * lock.lock()
         * some operation which requires exception handling
         * for such cases place lock.unlock() in finally block
         */
        lock.unlock();
    }
    
    public void Consumer() throws InterruptedException {
        lock.lock();
        System.out.println("Consumer");
        // Similar to notify
        condition.signal();
        lock.unlock();
    }
}
public class ReentrantLocks {
    public static void main(String[] args) {
        /**
         * A reentrant lock is similar to synchronized locks but with a few extensions
         * we can specify a fairness parameter by which the lock would abide by the order 
         * of the lock request i.e. after a thread unlocks the resource, 
         * the lock would go to the thread which has been waiting for the longest time. 
         * This fairness mode is set up by passing true to the constructor of the lock.
         * This helps prevent starvation
         *
         */
        Processor processor = new Processor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.Producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    processor.Consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
