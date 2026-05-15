package carts.service;

import carts.pojo.Cart;
import carts.pojo.CartBill;
import carts.pojo.DiscountResult;

import java.util.ArrayList;
import java.util.List;

public class DiscountEngine {

    private List<DiscountStrategy> strategies;

    public DiscountEngine(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    public CartBill calculateBill(Cart cart) {
        List<DiscountResult> discounts = new ArrayList<>();
        double cartTotal = cart.getCartTotal();
        double totalDiscount = 0.0;

        for (DiscountStrategy strategy : strategies) {
            DiscountResult result = strategy.applyDiscount(cart);
            discounts.add(result);
            totalDiscount = totalDiscount + result.getDiscountAmount();
        }

        double finalAmount = cartTotal - totalDiscount;

        if (finalAmount < 0) {
            finalAmount = 0;
        }

        return new CartBill(cartTotal, totalDiscount, finalAmount, discounts);
    }

    public List<DiscountStrategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }
}
