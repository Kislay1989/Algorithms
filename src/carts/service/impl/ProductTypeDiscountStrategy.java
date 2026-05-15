package carts.service.impl;

import carts.pojo.Cart;
import carts.pojo.DiscountResult;
import carts.service.DiscountStrategy;

public class ProductTypeDiscountStrategy implements DiscountStrategy {
    @Override
    public DiscountResult applyDiscount(Cart cart) {
        return null;
    }
}
