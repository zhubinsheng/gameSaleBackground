package com.hjf.controller;

import com.hjf.entity.Privatemsg;
import com.hjf.service.PrivatemsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/msg")
public class PrivatemsgController {

    @Autowired
    private PrivatemsgService privatemsgService;

    @PostMapping("/send")
    @ResponseBody
    public String Send(@RequestBody Privatemsg privatemsg){
        int res = privatemsgService.Send(privatemsg.getPrivatemsgSendid(),privatemsg.getPrivatemsgSendname(),
                privatemsg.getPrivatemsgAcceptid(),privatemsg.getPrivatemsgAcceptname(),
                privatemsg.getPrivatemsgContent());
        if(res == 0){
            System.out.println("发送失败");
            return "error";
        }else {
            System.out.println("发送成功");
            return "success";
        }
    }

    /**
     * 显示消息
     * @param privatemsg
     * @return
     */
    @PostMapping("/showmsg")
    @ResponseBody
    public ArrayList<Privatemsg> showMsg(@RequestBody Privatemsg privatemsg){
        ArrayList<Privatemsg> showmsg = privatemsgService.showMsg(privatemsg.getPrivatemsgAcceptid());
        System.out.println("显示消息成功");
        return showmsg;
    }

    @PostMapping("/refreshmsg")
    @ResponseBody
    public Privatemsg Refreshmsg(@RequestBody Privatemsg privatemsg){
        Privatemsg msg = privatemsgService.Refreshmsg(privatemsg.getPrivatemsgAcceptid());
        System.out.println("显示消息成功");
        return msg;
    }


}
