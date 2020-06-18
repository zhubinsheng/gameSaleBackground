package com.hjf.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartToOrder {

    private String cartName;

    private BigDecimal cartPrice;

    private Integer cartGameid;

    private Integer cartUserid;

}
