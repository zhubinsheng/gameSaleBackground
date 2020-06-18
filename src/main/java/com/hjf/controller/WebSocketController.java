package com.hjf.controller;

import com.hjf.component.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 暂时没用
 */
@Controller
@RequestMapping("/socket")
public class WebSocketController {
    @Autowired
    private WebSocket webSocket;

    @RequestMapping("/sendAllWebSocket")
    public String test() {
        webSocket.sendAllMessage("{\"data\":\"清晨起来打开窗，心情美美哒~\"}");
        return "websocket群体发送！";
    }

    @RequestMapping("/sendOneWebSocket")
    public String sendOneWebSocket() {
        webSocket.sendOneMessage("DPS007", "{\"data\":\"只要你乖给你买条gai！\"}");
        return "websocket单人发送";
    }
}