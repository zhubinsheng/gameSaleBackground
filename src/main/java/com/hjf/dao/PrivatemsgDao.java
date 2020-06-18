package com.hjf.dao;

import com.hjf.entity.Privatemsg;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Repository
public interface PrivatemsgDao {
    int SendPro(@RequestParam("privatemsgSendid") Integer privatemsgSendid,
                @RequestParam("privatemsgSendname") String privatemsgSendname,
                @RequestParam("privatemsgAcceptid") Integer privatemsgAcceptid,
                @RequestParam("privatemsgAcceptname") String privatemsgAcceptname,
                @RequestParam("privatemsgContent") String privatemsgContent,
                @RequestParam("privatemsgTime") String privatemsgTime);

    ArrayList<Privatemsg> showMsgPro(@RequestParam("privatemsgAcceptid") Integer privatemsgAcceptid);

    Privatemsg Refreshmsg(@RequestParam("privatemsgAcceptid")  Integer privatemsgAcceptid);
}
