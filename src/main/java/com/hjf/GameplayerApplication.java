package com.hjf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("com.hjf.dao")
//@EnableScheduling
public class GameplayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameplayerApplication.class, args);
    }


//    @Bean
//    public FrameSpringBeanUtil frameSpringBeanUtil(){
//        return new FrameSpringBeanUtil();
//    }

}
