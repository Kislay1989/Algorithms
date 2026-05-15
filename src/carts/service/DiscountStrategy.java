package carts.service;

import carts.pojo.Cart;
import carts.pojo.DiscountResult;

public interface DiscountStrategy {

    DiscountResult applyDiscount(Cart cart);
}
