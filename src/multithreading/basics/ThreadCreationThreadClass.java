package multithreading.basics;
/*
We create threads by extending the thread class
 */
class RunThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // We may do something like
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Sleep causes a thread to cease execution temporarily for the duration(in milliseconds) passed
            System.out.println("RUNNER 1 " + i);
        }
    }
}

class RunThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("RUNNER 2 " + i);
        }
    }
}

public class ThreadCreationThreadClass {
    public static void main(String[] args) {
        Thread t1 = new RunThread1();
        Thread t2 = new RunThread2();
        t1.start();
        t2.start();
                
    }
}
