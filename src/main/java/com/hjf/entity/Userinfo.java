package com.hjf.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class Userinfo {

    private Integer userinfoId;

    private String userinfoName;

    private String userinfoPwd;

    private String userinfoEmail;

    private String userinfoPhone;

    private String userinfoSex;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date userinfoBirthday;

    private Date userinfoCreatetime;

    private String userinfoImg;

}
