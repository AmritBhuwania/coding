package designPatterns.behavioral.observer;

public class Main {

    public static void main(String[] args) {

        InventoryOrchestrationService orchestratorService = new InventoryOrchestrationService();

        CartService cartService = new CartServiceImpl(orchestratorService);

        AddItemCartEventHandler addItemCartEventHandler = new AddItemCartEventHandler(cartService);

        orchestratorService.addCartEventListener(addItemCartEventHandler);

        //addItemCartEventHandler.handleEvent(new CartEvent("abc", 5));
        cartService.addItemToCart("abc", 5, 50.0);

        System.out.println(orchestratorService.getCartEventHandlerList());

        orchestratorService.getCartEventHandlerList().remove(addItemCartEventHandler);

        System.out.println(orchestratorService.getCartEventHandlerList());

        cartService.addItemToCart("abc", 5, 50.0);

    }

}
