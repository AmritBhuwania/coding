package multithreading.basics;

class DaemonThread implements Runnable{
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("RUNNER DAEMON ");
        }
    }
}

class WorkerThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("RUNNER Worker" + i);
        }
    }
}

public class WorkerAndDaemonThreads {
    public static void main(String[] args) {
        Thread t1 = new Thread(new WorkerThread());
        Thread t2 = new Thread(new DaemonThread());
        // this is how we mark a thread as daemon
        t2.setDaemon(true);
        t1.start();
        t2.start();
        /*
        Even though the daemon thread has an infinite loop,
        once the worker thread stops execution, the daemon is terminated by the JVM
         */
    }
}
