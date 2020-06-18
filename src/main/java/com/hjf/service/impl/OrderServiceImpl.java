package com.hjf.service.impl;

import com.hjf.dao.GameDao;
import com.hjf.dao.OrderDao;
import com.hjf.entity.Order;
import com.hjf.entity.OrderAndUser;
import com.hjf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    GameDao gameDao;

    @Override
    public ArrayList<OrderAndUser> showOrder(Integer orderUserid) {
        return orderDao.showOrderPro(orderUserid);
    }

    @Override
    public int deleteOrder(Integer orderId) {
        return orderDao.deleteOrderPro(orderId);
    }

    @Override
    public ArrayList<OrderAndUser> orderNorepeat(Integer orderUserid) {
        return orderDao.orderNorepeatPro(orderUserid);
    }

    @Override
    public ArrayList<Order> showAllorder() {
        return orderDao.showAllorderPro();
    }

    @Override
    public ArrayList<Order> showLike(String orderName) {
        return orderDao.showLikePro(orderName);
    }

    @Override
    public void updateBol(Integer gameid,Integer userid) {
        orderDao.updateBolPro(gameid,userid);
    }

    @Override
    public int insertOrder(String cartName, BigDecimal cartPrice, Integer cartGameid,
                           Integer cartUserid) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("订单创建时间：" + dateFormat.format(date));
        String orderTime =  dateFormat.format(date);
        return orderDao.insertOrderPro(cartName,cartPrice,orderTime,cartGameid,cartUserid);
    }

    @Override
    public void deleteOrderTwo(Integer gameId, Integer userId) {
        orderDao.deleteOrderTwoPro(gameId,userId);
    }

    @Override
    public Order showBuyStatus(Integer orderGameid, Integer orderUserid) {
        return orderDao.showBuyStatusPro(orderGameid,orderUserid);
    }
}
