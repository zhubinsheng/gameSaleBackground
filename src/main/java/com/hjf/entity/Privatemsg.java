package com.hjf.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Privatemsg {
    private Integer privatemsgId;

    private Integer privatemsgSendid;

    private String privatemsgSendname;

    private Integer privatemsgAcceptid;

    private String privatemsgAcceptname;

    private String privatemsgContent;

    private Date privatemsgTime;
}
