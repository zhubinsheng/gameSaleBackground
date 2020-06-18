package com.hjf.component;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint(value = "/Jqcase")
public class JqWebSock {

    private Session session = null;
    private Integer linkCount = 0;

    private static CopyOnWriteArraySet<JqWebSock> webSocketSet = new CopyOnWriteArraySet<JqWebSock>();

    /**
     * 新的客户端连接调用的方法
     * @param session
     * @throws IOException
     */
    @OnOpen
    public void onOpen(Session session) throws IOException{
        System.out.println("-------------有新的客户端连接----------");
        linkCount++;
        this.session = session;
        webSocketSet.add(this);
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message
     */
    @OnMessage
    public void onMessage(Session message) {
        System.out.println("发生变化"+message);
            try{
                sendMessage("发生变化"+message);
            }catch (Exception e){
                e.printStackTrace();
            }
    }

    /**
     * 发送信息调用的方法
     * @param message
     * @throws IOException
     */
    public static void sendMessage(String message) throws IOException{
        for (JqWebSock item : webSocketSet) {

            item.session.getBasicRemote().sendText(message);

        }
    }

    @OnClose
    public void onClose(){
        linkCount--;
        webSocketSet.remove(this);
    }

    @OnError
    public void onError(Session session,Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }
}
