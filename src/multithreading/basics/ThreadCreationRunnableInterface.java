package multithreading.basics;
/*
The first basic way to create a thread is by implementing the runnable interface
By doing so we need to override the run() method

Runnable interface is implemented by classes whose instances we want to be executed by a thread
 */
/**
 * The <code>Runnable</code> interface should be implemented by any
 * class whose instances are intended to be executed by a thread. The
 * class must define a method of no arguments called <code>run</code>.
 * <p>
 * This interface is designed to provide a common protocol for objects that
 * wish to execute code while they are active. For example,
 * <code>Runnable</code> is implemented by class <code>Thread</code>.
 * Being active simply means that a thread has been started and has not
 * yet been stopped.
 * <p>
 * In addition, <code>Runnable</code> provides the means for a class to be
 * active while not subclassing <code>Thread</code>. A class that implements
 * <code>Runnable</code> can run without subclassing <code>Thread</code>
 * by instantiating a <code>Thread</code> instance and passing itself in
 * as the target.  In most cases, the <code>Runnable</code> interface should
 * be used if you are only planning to override the <code>run()</code>
 * method and no other <code>Thread</code> methods.
 * This is important because classes should not be subclassed
 * unless the programmer intends on modifying or enhancing the fundamental
 * behavior of the class.
 *
 * @author  Arthur van Hoff
 * @see     java.lang.Thread
 * @see     java.util.concurrent.Callable
 * @since   JDK1.0
 */

class Run1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("RUNNER 1 " + i);
        }
    }
}

class Run2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("RUNNER 2 " + i);
        }
    }
}

public class ThreadCreationRunnableInterface {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Run1());
        Thread t2 = new Thread(new Run2());
        t1.start();
        t2.start();
        /**
         * This is not parallel execution.
         * This is a case of multithreading wherein the OS is executing threads based on time slicing
         * That is it executes each thread for a specific amount of interval and then switches to the next
         * and so on
         * Only a single core is being used here
         */
    }
}
