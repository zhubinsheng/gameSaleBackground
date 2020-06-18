package com.hjf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class Post {

    private Integer postId;

    private String postTitle;

    private String postContent;

    private Date postTime;

    private Integer postThumbs;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Integer postUserid;

    private String postUsername;

    private Integer postCommons;

}
