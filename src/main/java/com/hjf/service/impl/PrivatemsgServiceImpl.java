package com.hjf.service.impl;

import com.hjf.dao.PrivatemsgDao;
import com.hjf.entity.Privatemsg;
import com.hjf.service.PrivatemsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class PrivatemsgServiceImpl implements PrivatemsgService {

    @Autowired
    private PrivatemsgDao privatemsgDao;

    @Override
    public int Send(Integer privatemsgSendid, String privatemsgSendname, Integer privatemsgAcceptid,
                    String privatemsgAcceptname, String privatemsgContent) {
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("用户发送时间：" + dateFormat.format(date));
        String privatemsgTime =  dateFormat.format(date);
        return privatemsgDao.SendPro(privatemsgSendid,privatemsgSendname,privatemsgAcceptid,privatemsgAcceptname,
                privatemsgContent,privatemsgTime);
    }

    @Override
    public ArrayList<Privatemsg> showMsg(Integer privatemsgAcceptid) {
        return privatemsgDao.showMsgPro(privatemsgAcceptid);
    }

    @Override
    public Privatemsg Refreshmsg(Integer privatemsgAcceptid) {
        return privatemsgDao.Refreshmsg(privatemsgAcceptid);
    }
}
