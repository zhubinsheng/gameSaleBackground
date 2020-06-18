package com.hjf.dao;

import com.hjf.entity.Userinfo;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


@Repository
public interface UserDao {

    Userinfo loginPro(@RequestParam("userinfoName") String userinfoName,
                      @RequestParam("userinfoPwd") String userinfoPwd);

    int registerPro(@RequestParam("userinfoName") String userinfoName,
                    @RequestParam("userinfoPwd") String userinfoPwd,
                    @RequestParam("userinfoCreatetime") String userinfoCreatetime);


    Userinfo showUserPro(@RequestParam("userinfoId") Integer userinfoId);

    int updatePwdPro(@RequestParam("userinfoPwd") String userinfoPwd,
                     @RequestParam("userinfoId") Integer userinfoId);

    ArrayList<Userinfo> showAlluserPro();

    int insertUserPro(@RequestParam("userinfoName") String userinfoName,
                      @RequestParam("userinfoPwd") String userinfoPwd,
                      @RequestParam("userinfoEmail") String userinfoEmail,
                      @RequestParam("userinfoPhone") String userinfoPhone,
                      @RequestParam("userinfoSex") String userinfoSex,
                      @RequestParam("userinfoBirthday") Date userinfoBirthday,
                      @RequestParam("userinfoCreatetime") String userinfoCreatetime,
                      @RequestParam("userinfoImg") String userinfoImg);

    int deleteUserPro(@RequestParam("userinfoId") Integer userinfoId);

    int updateUserPro(@RequestParam("userinfoImg") String userinfoImg,
                      @RequestParam("userinfoName") String userinfoName,
                      @RequestParam("userinfoSex") String userinfoSex,
                      @RequestParam("userinfoBirthday") Date userinfoBirthday,
                      @RequestParam("userinfoId") Integer userinfoId);

    Map getSexPro();

    Map getAgePro();

    Userinfo duplicatePro(@RequestParam("userinfoName") String userinfoName);

    Userinfo getUserIdPro(@RequestParam("userinfoName") String userinfoName);

    int updateEmailPro(@RequestParam("userinfoEmail") String userinfoEmail,
                       @RequestParam("userinfoId") Integer userinfoId);

    int updatePhonePro(@RequestParam("userinfoPhone")String userinfoPhone,
                       @RequestParam("userinfoId")Integer userinfoId);

    Userinfo getUserPro(@RequestParam("userinfoName") String userinfoName);

    void updateSendname(@RequestParam("userinfoId") String userinfoName,
                        @RequestParam("userinfoId")Integer userinfoId);

    void updateAcceptname(@RequestParam("userinfoId") String userinfoName,
                        @RequestParam("userinfoId")Integer userinfoId);

    void updatePsotname(@RequestParam("userinfoId") String userinfoName,
                        @RequestParam("userinfoId") Integer userinfoId);

    ArrayList<Userinfo> showLikePro(@RequestParam("userinfoName") String userinfoName);
}
