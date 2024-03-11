package multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable{
    int taskId;
    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " underway, using thread " + Thread.currentThread().getName());
        long duration = (long) (Math.random() * 5);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SingleThreadExecutor {
    public static void main(String[] args) {
        // It is a single thread that will execute tasks sequentially
        /**
         * Creates an Executor that uses a single worker thread operating off an unbounded queue. 
         * (Note however that if this single thread terminates due to a failure during execution
         * prior to shutdown, a new one will take its place if needed to execute subsequent tasks.) 
         * Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time.
         * Unlike the otherwise equivalent newFixedThreadPool(1) the returned executor 
         * is guaranteed not to be reconfigurable to use additional threads
         */
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10 ; i++) {
            executor.execute(new Task(i));
        }

        // to shut executor
        //executor.shutdown();
        // Note that shutdown does the following
        /*
        Initiates an orderly shutdown in which previously submitted tasks are executed, 
        but no new tasks will be accepted. Invocation has no additional effect if already shut down.
        This method does not wait for previously submitted tasks to complete execution.
         Use awaitTermination to do that.
         */
        // Ideally we do this
        try {
            if (!executor.awaitTermination(1000,TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
/* Sample Output
Task 0 underway, using thread pool-1-thread-1
Task 1 underway, using thread pool-1-thread-1
Task 2 underway, using thread pool-1-thread-1
Task 3 underway, using thread pool-1-thread-1
Task 4 underway, using thread pool-1-thread-1


As we can see only one thread is used for the tasks
 */