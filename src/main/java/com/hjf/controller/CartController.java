package com.hjf.controller;

import com.hjf.entity.Cart;
import com.hjf.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    /**
     * 显示个人购物车商品
     * @return
     */
    @PostMapping("/showcart")
    @ResponseBody
    public ArrayList<Cart> showCart(@RequestBody Cart cart){
        ArrayList<Cart> showCart = cartService.showCart(cart.getCartUserid());
        System.out.println("显示个人购物车商品");
        return showCart;
    }

    /**
     * 显示是否购物车是否存在相同商品
     * @return
     */
    @PostMapping("/buybol")
    @ResponseBody
    public String buyBol(@RequestBody Cart cart){
        Cart buybol = cartService.buyBol(cart.getCartGameid(),cart.getCartUserid());
        if(buybol==null){
            System.out.println("没有这个商品");
            return "success";
        }else {
            System.out.println("购物车已存在商品");
            return "error";
        }
    }

    /**
     * 用户添加商品到购物车
     * @return
     */
    @PostMapping("/insertcart")
    @ResponseBody
    public String insertCart(@RequestBody Cart cart){
        int res = cartService.insertCart(cart.getCartName(),cart.getCartImg(),cart.getCartPrice(),
                cart.getCartUserid(),cart.getCartGameid());
        if(res == 0){
            System.out.println("添加购物车失败");
            return "error";
        }else {
            System.out.println("添加购物车成功");
            return "success";
        }
    }

    /**
     * 删除购物车中的商品
     * @return
     */
    @PostMapping("/deletecart")
    @ResponseBody
    public String deleteCart(@RequestBody Cart cart){
        int res = cartService.deleteCart(cart.getCartId(),cart.getCartUserid());
        if(res == 0){
            System.out.println("删除个人的购物车商品失败");
            return "error";
        }else {
            System.out.println("删除个人的购物车商品成功");
            return "success";
        }
    }

}
