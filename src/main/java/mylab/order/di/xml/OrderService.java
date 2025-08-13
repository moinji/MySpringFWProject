package mylab.order.di.xml;

public class OrderService {
    private ShoppingCart shoppingCart;
    
    public OrderService() {}
    
    // Setter for Dependency Injection
    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    
    // Getter
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
    
    public double calculateOrderTotal() {
        if (shoppingCart != null) {
            return shoppingCart.getTotalPrice();
        }
        return 0.0;
    }
    
    @Override
    public String toString() {
        return "OrderService [shoppingCart=" + shoppingCart + "]";
    }
}