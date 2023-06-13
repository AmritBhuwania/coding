package designPatterns.creational.singleton;

public class BillPughSingleton {

    private BillPughSingleton() {}

    private static class InnerStaticClass {
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return InnerStaticClass.instance;
    }
}
