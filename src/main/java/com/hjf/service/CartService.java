package com.hjf.service;

import com.hjf.entity.Cart;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface CartService {

    ArrayList<Cart> showCart(Integer cartUserid);

    int insertCart(String cartName, String cartImg, BigDecimal cartPrice,
                   Integer cartUserid, Integer cartGameid);

    int deleteCart(Integer cartId,Integer cartUserid);

    Cart buyBol(Integer cartGameid, Integer cartUserid);

    int deleteCartToOrder(Integer cartGameid,Integer cartUserid);

    Cart showCartTo(Integer cartGameid, Integer cartUserid);

}
