package com.pri;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * className: AppMember <BR>
 * description: 会员服务入口<BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/2/16 23:09 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2Doc
public class AppMember {
    public static void main(String[] args) {
        SpringApplication.run(AppMember.class,args);
    }
}
