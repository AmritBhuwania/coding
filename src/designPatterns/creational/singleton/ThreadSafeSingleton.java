package designPatterns.creational.singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    private static ThreadSafeSingleton getInstance() {

        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (null == instance) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }

}
