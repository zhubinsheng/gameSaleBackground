package com.hjf.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentAndUser {
    private Integer userinfoId;

    private String commentUserimg;

    private String userinfoName;

    private Timestamp commentTime;

    private String commentContent;

    private Integer commentPostid;
}
