package multithreading.basics;

class Thread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("RUNNER 1 " + i);
        }
    }
}

class Thread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("RUNNER 2 " + i);
        }
    }
}
public class ThreadWaiting {

    public static void main(String[] args) throws InterruptedException {
        // to get name of current thread
        String name = Thread.currentThread().getName();
        System.out.println(name);
        /*
        Let us consider an example wherein we have the following sequence
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        System.out.println("Threads done");
        
        If we want to guarantee that the print line is executed only after both threads finish execution
        we can use join(). threadName.join() will tell the main thread to wait for execution of this
        thread to complete before proceeding ahead
         */
        Thread t1 = new Thread(new Thread1());
        Thread t2 = new Thread(new Thread2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Threads done");
        
        // For the above case we have guaranteed that thread1 execution is completed before we print
    }
}
