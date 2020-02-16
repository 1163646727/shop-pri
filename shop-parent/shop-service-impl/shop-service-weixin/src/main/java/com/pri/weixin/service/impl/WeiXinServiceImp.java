package com.pri.weixin.service.impl;

import com.pri.entity.AppEntity;
import com.pri.weixin.service.WeiXinService;
import org.springframework.web.bind.annotation.RestController;

/**
 * className: WeiXinServiceImp <BR>
 * description: 微信接口的实现<BR>
 * remark: 1.为什么命名为Servce，而不是Controller<BR>
 *         因为这层是接口，接口没有视图层，<BR>
 *         2.实现层需要写Springmvv的url注册吗？<BR>
 *         不需要，因为已经在接口中写了，实现层只需要继承过来用就可以了
 * auther: ChenQi <BR>
 * date: 2020/2/16 22:13 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@RestController
public class WeiXinServiceImp implements WeiXinService {
    @Override
    public AppEntity getAppEntity() {
        AppEntity appEntity = new AppEntity();
        appEntity.setAppName("zhangsan");
        appEntity.setAppId("123");
        return appEntity;
    }
}
