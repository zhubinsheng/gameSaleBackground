package com.hjf.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class OrderAndUser {

    private Integer orderId;

    private String orderName;

    private Timestamp orderTime;

    private BigDecimal orderPrice;

    private Integer orderGameid;

    private Integer orderUserid;

    private String gameImg;
}
