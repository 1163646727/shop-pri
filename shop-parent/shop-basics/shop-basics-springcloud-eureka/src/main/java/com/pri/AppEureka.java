package com.pri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * className: AppEureka <BR>
 * description: 注册中心Eureka启动入口<BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/2/16 19:39 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@SpringBootApplication
@EnableEurekaServer
public class AppEureka {
    public static void main(String[] args) {
        SpringApplication.run (AppEureka.class,args);
    }
}
