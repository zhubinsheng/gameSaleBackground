package com.hjf.service.impl;

import com.hjf.dao.UserDao;
import com.hjf.entity.Userinfo;
import com.hjf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Userinfo login(String userinfoName, String userinfoPwd) {
        return userDao.loginPro(userinfoName,userinfoPwd);
    }

    @Override
    public int register(String userinfoName, String userinfoPwd) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("用户创建时间：" + dateFormat.format(date));
        String userinfoCreatetime =  dateFormat.format(date);
        return userDao.registerPro(userinfoName,userinfoPwd,userinfoCreatetime);
    }

    @Override
    public int updateUser(String userinfoImg,String userinfoName, String userinfoSex, Date userinfoBirthday, Integer userinfoId) {
        userDao.updateSendname(userinfoName,userinfoId);
        userDao.updateAcceptname(userinfoName,userinfoId);
        userDao.updatePsotname(userinfoName,userinfoId);
        return userDao.updateUserPro(userinfoImg,userinfoName,userinfoSex,userinfoBirthday,userinfoId);
    }

    @Override
    public Userinfo showUser(Integer userinfoId) {
        return userDao.showUserPro(userinfoId);
    }

    @Override
    public int updatePwd(String userinfoPwd, Integer userinfoId) {
        return userDao.updatePwdPro(userinfoPwd,userinfoId);
    }

    @Override
    public ArrayList<Userinfo> showAllUser() {
        return userDao.showAlluserPro();
    }

    @Override
    public int insertUser(String userinfoName, String userinfoPwd, String userinfoEmail, String userinfoPhone,
                          String userinfoSex, Date userinfoBirthday,String userinfoImg) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("用户创建时间：" + dateFormat.format(date));
        String userinfoCreatetime =  dateFormat.format(date);
        return userDao.insertUserPro(userinfoName,userinfoPwd,userinfoEmail,userinfoPhone,userinfoSex,
                userinfoBirthday,userinfoCreatetime,userinfoImg);
    }

    @Override
    public int deleteUser(Integer userinfoId) {
        return userDao.deleteUserPro(userinfoId);
    }

    @Override
    public Map getSex() {
        Map getsex = userDao.getSexPro();
        return getsex;
    }

    @Override
    public Map getAge() {
        Map getAge = userDao.getAgePro();
        return getAge;
    }

    @Override
    public Userinfo duplicate(String userinfoName) {
        return userDao.duplicatePro(userinfoName);
    }

    @Override
    public Userinfo getUserId(String userinfoName) {
        return userDao.getUserIdPro(userinfoName);
    }

    @Override
    public int updateEmail(String userinfoEmail, Integer userinfoId) {
        return userDao.updateEmailPro(userinfoEmail,userinfoId);
    }

    @Override
    public int updatePhone(String userinfoPhone, Integer userinfoId) {
        return userDao.updatePhonePro(userinfoPhone,userinfoId);
    }

    @Override
    public Userinfo getUser(String userinfoName) {
        return userDao.getUserPro(userinfoName);
    }

    @Override
    public ArrayList<Userinfo> showLike(String userinfoName) {
        return userDao.showLikePro(userinfoName);
    }
}
