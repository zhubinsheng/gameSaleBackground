package com.hjf.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfig {

    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
