package designPatterns.behavioral.observer;

public interface CartEventHandler {
    void handleEvent(CartEvent cartEvent);
}
