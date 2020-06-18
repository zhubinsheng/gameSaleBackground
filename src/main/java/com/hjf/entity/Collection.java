package com.hjf.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Collection {

    private Integer collectionId;

    private String collectionName;

    private BigDecimal collectionPrice;

    private String collectionImg;

    private Integer collectionGameid;

    private Integer collectionUserid;

}
