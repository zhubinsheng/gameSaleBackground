package com.hjf.controller;

import com.alibaba.fastjson.JSON;
import com.hjf.entity.*;
import com.hjf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 显示所有订单
     * @return
     */
    @PostMapping("/showallorder")
    @ResponseBody
    public ArrayList<Order> showAllorder(){
        ArrayList<Order> show = orderService.showAllorder();
        System.out.println("查询用户订单成功");
        return show;

    }

    /**
     * 显示用户订单
     * @return
     */
    @PostMapping("/showorder")
    @ResponseBody
    public ArrayList<OrderAndUser> showOrder(@RequestBody OrderAndUser order){
        ArrayList<OrderAndUser> show = orderService.showOrder(order.getOrderUserid());
        System.out.println("查询用户订单成功");
        return show;

    }

    /**
     * 显示用户订单
     * @return
     */
    @PostMapping("/showbuystatus")
    @ResponseBody
    public String showBuyStatus(@RequestBody Order order){
        Order o = orderService.showBuyStatus(order.getOrderGameid(),order.getOrderUserid());
        if(o == null){
            return "error";
        }else {
            return "success";
        }

    }

//    /**
//     * 购物车商品放入订单
//     * @return
//     */
//    @PostMapping("/insertorder")
//    @ResponseBody
//    public String insertOrder(@RequestBody ArrayList<Cart> cto){
//        int res = 0;
//        for (int i = 0; i < cto.size(); i++){
//            Cart order = cto.get(i);
//             res = orderService.insertOrder(order.getCartName(),order.getCartPrice(),
//                    order.getCartGameid(),order.getCartUserid());
//        }
//        if(res == 0){
//            return "error";
//        }else {
//            return "success";
//        }
//    }

    /**
     * 点购买时商品放入订单
     * @return
     */
    @PostMapping("/addorder")
    @ResponseBody
    public String addOrder(@RequestBody Cart cto){
        int res = orderService.insertOrder(cto.getCartName(),cto.getCartPrice(),
                cto.getCartGameid(),cto.getCartUserid());
        if(res == 0){
            return "error";
        }else {
            return "success";
        }
    }

    @PostMapping("/deleteorder")
    @ResponseBody
    public String deleteOder(@RequestBody Order order){
        int res = orderService.deleteOrder(order.getOrderId());
        if(res == 0){
            return "error";
        }else {
            return "success";
        }
    }

    /**
     * 显示用户订单中不重复的数据
     * @return
     */
    @PostMapping("/ordernorepeat")
    @ResponseBody
    public ArrayList<OrderAndUser> orderNorepeat(@RequestBody OrderAndUser order){
        ArrayList<OrderAndUser> ordernorepeat = orderService.orderNorepeat(order.getOrderUserid());
        System.out.println("查询用户订单成功");
        return ordernorepeat;

    }

    /**
     * 模糊查询
     * @return
     */
    @PostMapping("/showlike")
    @ResponseBody
    public ArrayList<Order> showLike(@RequestBody Order order){
        ArrayList<Order> showLike = orderService.showLike(order.getOrderName());
        System.out.println("模糊查询成功");
        return showLike;
    }
}
