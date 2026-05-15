package carts.pojo;

import carts.pojo.enums.DiscountType;

public class DiscountResult {

    private DiscountType discountType;
    private double discountAmount;
    private String description;

    public DiscountResult(DiscountType discountType, double discountAmount, String description) {
        this.discountType = discountType;
        this.discountAmount = discountAmount;
        this.description = description;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
