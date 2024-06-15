package designPatterns.behavioral.observer;

public class AddItemCartEventHandler implements CartEventHandler {


    private CartService cartService;
//    private InventoryService inventoryService;
//    private PricingService pricingService;
//    private DiscountingService discountingService;


    public AddItemCartEventHandler(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public void handleEvent(CartEvent cartEvent) {

        String productId = cartEvent.getProductId();
        Integer quantity = cartEvent.getQuantity();


//        Product product = inventoryService.getProductById(productId);
//        double price = pricingService.getPriceOfProduct(productId);
//        double discountedPrice =  discountingService.getDiscountedPrice(productId, price);
        System.out.println("Inside AddItemCartEventHandler handle method");

        //cartService.addItemToCart(productId, quantity, 50.0);

    }

    @Override
    public String toString() {
        return "AddItemCartEventHandler{" +
                "cartService=" + cartService +
                '}';
    }
}
