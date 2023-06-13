package designPatterns.creational.singleton;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {};

    public LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }

        return instance;
    }
}
