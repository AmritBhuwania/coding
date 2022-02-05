package multithreading.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task1 implements Runnable{
    int taskId;
    public Task1(int taskId) {
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

public class FixedThreadPoolExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executor.execute(new Task1(i));
        }
    }
}
/*
Sample output

Task 0 underway, using thread pool-1-thread-1
Task 1 underway, using thread pool-1-thread-2
Task 2 underway, using thread pool-1-thread-3
Task 3 underway, using thread pool-1-thread-4
Task 4 underway, using thread pool-1-thread-5
Task 5 underway, using thread pool-1-thread-3
Task 6 underway, using thread pool-1-thread-1
Task 7 underway, using thread pool-1-thread-2
Task 8 underway, using thread pool-1-thread-1
Task 9 underway, using thread pool-1-thread-1
 */