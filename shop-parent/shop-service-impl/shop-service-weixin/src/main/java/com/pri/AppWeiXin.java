package com.pri;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * className: AppWeiXin <BR>
 * description: 微信服务项目入口<BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/2/16 22:25 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
public class AppWeiXin {
    public static void main(String[] args) {
        SpringApplication.run(AppWeiXin.class,args);
    }
}
