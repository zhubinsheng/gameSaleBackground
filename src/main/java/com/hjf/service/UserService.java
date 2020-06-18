package com.hjf.service;

import com.hjf.entity.Userinfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


public interface UserService {

    Userinfo login(String userinfoName, String userinfoPwd);

    int register(String userinfoName,String userinfoPwd);

    int updateUser(String userinfoImg,String userinfoName, String userinfoSex, Date userinfoBirthday, Integer userinfoId);

    Userinfo showUser(Integer userinfoId);

    int updatePwd(String userinfoPwd, Integer userinfoId);

    ArrayList<Userinfo> showAllUser();

    int insertUser(String userinfoName,String userinfoPwd,String userinfoEmail,String userinfoPhone,
                   String userinfoSex,Date userinfoBirthday,String userinfoImg);

    int deleteUser(Integer userinfoId);

    Map getSex();

    Map getAge();

    Userinfo duplicate(String userinfoName);

    Userinfo getUserId(String userinfoName);

    int updateEmail(String userinfoEmail, Integer userinfoId);

    int updatePhone(String userinfoPhone, Integer userinfoId);

    Userinfo getUser(String userinfoName);

    ArrayList<Userinfo> showLike(String userinfoName);
}
