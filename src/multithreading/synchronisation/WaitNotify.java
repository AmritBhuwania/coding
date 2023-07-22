package multithreading.synchronisation;

class Process {
    public void producer() throws InterruptedException {
       synchronized (this) {
           System.out.println("Producer");
           wait();
           System.out.println("Producer again");
       }       
    }
    
    public void consumer() throws InterruptedException {
        synchronized (this) {
            System.out.println("consumer");
            notify();
            Thread.sleep(1000);
            System.out.println("Consumer exit");
        }
       
    }
}
public class WaitNotify {
    public static void main(String[] args) {
        Process processor = new Process();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                
                    try {
                        processor.producer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }  
                               
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               
                    try {
                        processor.consumer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } 
                }               
            
        });
         t1.start();
         t2.start();
    }

    /**
     * Threads can communicate with each other via wait() and notify()
     * These wait and notify methods can be called from synchronized methods/blocks only
     * Threads that are locking on the same intrinsic lock can release the lock
     * until the other thread calls notify
     * When wait is called the thread releases the lock and when notify is called the
     * initial waiting thread resumes execution
     * 
     * IMP!!!! - When notify is called (assume called by thread t2) control does not go back 
     * to waiting thread immediately(t1)
     * The synchronized block of t2 is first executed before transferring control
     * in this case  Thread.sleep(500); will be executed first, once the block is done control goes back to t1
     
     Wait and notify will work only when two synchronized methods have acquired the same lock
     */
}
