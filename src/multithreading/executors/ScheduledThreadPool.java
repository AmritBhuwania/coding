package multithreading.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Task2 implements Runnable{
    int taskId;
    public Task2(int taskId) {
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

public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 4; i++) {
            executor.scheduleAtFixedRate(new Task2(i), 1000, 3000, TimeUnit.MILLISECONDS);
        }
    }
}
