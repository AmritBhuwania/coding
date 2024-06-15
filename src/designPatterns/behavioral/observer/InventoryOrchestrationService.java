package designPatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class InventoryOrchestrationService {

    private final List<CartEventHandler> cartEventHandlerList = new ArrayList<>();

    public void addCartEventListener(CartEventHandler cartEventHandler) {
        this.cartEventHandlerList.add(cartEventHandler);
    }

    public void removeCartEventListener(CartEventHandler cartEventHandler) {
        this.cartEventHandlerList.remove(cartEventHandler);
    }

    public List<CartEventHandler> getCartEventHandlerList() {
        return cartEventHandlerList;
    }

    public void notifyCartEventListener(CartEvent cartEvent) {

        if (cartEventHandlerList.size() > 0) {
            for (CartEventHandler eventHandler : cartEventHandlerList) {
                System.out.println("Notifying to eventHandler: " + eventHandler + ", for event: " + cartEvent);
                eventHandler.handleEvent(cartEvent);
            }
        } else {
            System.out.println("No listener found");
        }
    }
}
