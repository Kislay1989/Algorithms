package carts.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {

    private final String cartID;

    private final User user;
    private List<Product> products;
    private Coupon coupon;

    private double cartTotal;

    public Cart(User user) {
        this.cartID = UUID.randomUUID().toString();
        this.user = user;
        products = new ArrayList<>();
    }

    public String getCartID() {
        return cartID;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(double cartTotal) {
        this.cartTotal = cartTotal;
    }
}
