package com.hjf.dao;

import com.hjf.entity.Cart;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;

@Repository
public interface CartDao {
    ArrayList<Cart> showCartPro(@RequestParam("cartUserid") Integer cartUserid);

    int insertCartPro(@RequestParam("cartName") String cartName,
                      @RequestParam("cartImg") String cartImg,
                      @RequestParam("cartPrice") BigDecimal cartPrice,
                      @RequestParam("cartUserid") Integer cartUserid,
                      @RequestParam("cartGameid") Integer cartGameid);

    int deleteCartPro(@RequestParam("cartId") Integer cartId,
                      @RequestParam("cartUserid") Integer cartUserid);

    Cart buyBolPro(@RequestParam("cartGameid") Integer cartGameid,
                   @RequestParam("cartUserid") Integer cartUserid);

    int deleteCartToOrderPro(@RequestParam("cartGameid") Integer cartGameid,
                             @RequestParam("cartUserid") Integer cartUserid);

    Cart showCartToPro(@RequestParam("cartGameid") Integer cartGameid,
                       @RequestParam("cartUserid") Integer cartUserid);
}
