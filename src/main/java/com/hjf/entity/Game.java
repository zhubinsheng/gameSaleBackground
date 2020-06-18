package com.hjf.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Game implements Serializable {

    private Integer gameId;

    private String gameName;

    private BigDecimal gamePrice;

    private String gameDescription;

    private BigDecimal gameDiscount;

    private Boolean gamePromotion;

    private String gameCharacter;

    private String gameImg;

    private String gameDown;

    private Integer gameSale;

    private Date gameTime;

}
