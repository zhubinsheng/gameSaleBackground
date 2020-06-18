package com.hjf.service.impl;

import com.hjf.dao.CartDao;
import com.hjf.entity.Cart;
import com.hjf.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Override
    public ArrayList<Cart> showCart(Integer cartUserid) {
        return cartDao.showCartPro(cartUserid);
    }

    @Override
    public int insertCart(String cartName, String cartImg, BigDecimal cartPrice,
                          Integer cartUserid, Integer cartGameid) {
        return cartDao.insertCartPro(cartName,cartImg,cartPrice,cartUserid,cartGameid);
    }

    @Override
    public int deleteCart(Integer cartId,Integer cartUserid) {
        return cartDao.deleteCartPro(cartId,cartUserid);
    }

    @Override
    public Cart buyBol(Integer cartGameid, Integer cartUserid) {
        return cartDao.buyBolPro(cartGameid,cartUserid);
    }

    @Override
    public int deleteCartToOrder(Integer cartGameid, Integer cartUserid) {
        return cartDao.deleteCartToOrderPro(cartGameid,cartUserid);
    }

    @Override
    public Cart showCartTo(Integer cartGameid, Integer cartUserid) {
        return cartDao.showCartToPro(cartGameid,cartUserid);
    }
}
