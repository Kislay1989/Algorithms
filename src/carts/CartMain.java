package carts;

import carts.pojo.*;
import carts.pojo.enums.ProductType;
import carts.pojo.enums.UserType;
import carts.service.DiscountEngine;
import carts.service.DiscountStrategy;
import carts.service.impl.CouponDiscountStrategy;
import carts.service.impl.ProductTypeDiscountStrategy;
import carts.service.impl.UserTypeDiscountStrategy;

import java.util.List;

public class CartMain {

    public static void main(String[] args) {
        User user = new User("U1", "Ramesh", UserType.PREMIUM);

        Product shirt = new Product("P1", "Shirt", ProductType.FASHION, 1000);
        Product phone = new Product("P2", "Phone", ProductType.ELECTRONICS, 20000);
        Product book = new Product("P3", "Book", ProductType.BOOKS, 500);

        Cart cart = new Cart(user);
        cart.getProducts().add(shirt);
        cart.getProducts().add(phone);
        cart.getProducts().add(book);

        Coupon coupon = new Coupon("SALE10", 10);
        cart.setCoupon(coupon);

        List<DiscountStrategy> strategies = List.of(
                new ProductTypeDiscountStrategy(),
                new UserTypeDiscountStrategy(),
                new CouponDiscountStrategy()
        );

        DiscountEngine discountEngine = new DiscountEngine(strategies);

        CartBill bill = discountEngine.calculateBill(cart);
        System.out.println(bill);
    }
}
