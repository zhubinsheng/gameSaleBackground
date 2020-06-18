package com.hjf.dao;

import com.hjf.entity.Order;
import com.hjf.entity.OrderAndUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

@Repository
public interface OrderDao {

    ArrayList<OrderAndUser> showOrderPro(@RequestParam("orderUserid") Integer orderUserid);

    int insertOrderPro(@RequestParam("cartName") String cartName,
                       @RequestParam("cartPrice") BigDecimal cartPrice,
                       @RequestParam("orderTime") String orderTime,
                       @RequestParam("cartGameid") Integer cartGameid,
                       @RequestParam("cartUserid") Integer cartUserid);

    int deleteOrderPro(@RequestParam("orderId") Integer orderId);

    ArrayList<OrderAndUser> orderNorepeatPro(Integer orderUserid);

    ArrayList<Order> showAllorderPro();

    ArrayList<Order> showLikePro(@RequestParam("orderName") String orderName);

    void updateBolPro(@RequestParam("gameid") Integer gameid,
                      @RequestParam("userid") Integer userid);

    void updateName(@RequestParam("gameId") Integer gameId,
                    @RequestParam("gameName") String gameName);

    void deleteOrderTwoPro(@RequestParam("gameId") Integer gameId,
                           @RequestParam("userId") Integer userId);

    Order showBuyStatusPro(@RequestParam("orderGameid") Integer orderGameid,
                         @RequestParam("orderUserid") Integer orderUserid);
}
