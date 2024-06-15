package designPatterns.behavioral.observer;

public class CartServiceImpl implements CartService {

    private InventoryOrchestrationService orchestrationService;

    public CartServiceImpl(InventoryOrchestrationService orchestrationService) {
        this.orchestrationService = orchestrationService;
    }

    @Override
    public void addItemToCart(String productId, Integer quantity, Double price) {
        System.out.println("Added to cart");
        orchestrationService.notifyCartEventListener(new CartEvent(productId, quantity));
    }
}
