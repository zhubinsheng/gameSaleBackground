package com.hjf.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cart {

    private Integer cartId;

    private String cartName;

    private String cartImg;

    private BigDecimal cartPrice;

    private Integer cartUserid;

    private Integer cartGameid;

}
