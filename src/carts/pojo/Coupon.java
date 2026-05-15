package carts.pojo;

public class Coupon {

    private String couponCode;
    private double discountPercentage;

    public Coupon(String couponCode, double discountPercentage) {
        this.couponCode = couponCode;
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public String getCouponCode() {
        return couponCode;
    }

     public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
