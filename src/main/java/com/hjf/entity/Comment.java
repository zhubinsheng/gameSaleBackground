package com.hjf.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {

    private Integer commentId;

    private String commentPostname;

    private String commentUserimg;

    private String commentContent;

    private Timestamp commentTime;

    private Integer commentUserid;

    private Integer commentPostid;

}
