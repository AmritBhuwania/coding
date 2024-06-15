package designPatterns.behavioral.observer;

public interface CartService {
    void addItemToCart(String productId, Integer quantity, Double price);

    //void removeItem(String productId);
}
