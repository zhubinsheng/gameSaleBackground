package com.hjf.entity;

import lombok.Data;

@Data
public class PostAndUser {

    private Integer postId;

    private String postTitle;

    private String postContent;

    private String userinfoImg;

    private String userinfoName;

    private String postTime;

    private String postThumbs;

    private String postCommons;

    private Integer userinfoId;
}
