package carts.pojo;

import java.util.List;

public class CartBill {

    private final double cartTotal;
    private final double totalDiscount;
    private final double finalAmount;
    private final List<DiscountResult> discountBreakdown;

    public CartBill(double cartTotal, double totalDiscount, double finalAmount, List<DiscountResult> discountBreakdown) {
        this.cartTotal = cartTotal;
        this.totalDiscount = totalDiscount;
        this.finalAmount = finalAmount;
        this.discountBreakdown = discountBreakdown;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public List<DiscountResult> getDiscountBreakdown() {
        return discountBreakdown;
    }
}
