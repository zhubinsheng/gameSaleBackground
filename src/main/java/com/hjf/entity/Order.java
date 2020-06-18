package com.hjf.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class Order {

    private Integer orderId;

    private String orderName;

    private BigDecimal orderPrice;

    private Timestamp orderTime;

    private Integer orderGameid;

    private Integer orderUserid;

    private Boolean orderStatus;

}
