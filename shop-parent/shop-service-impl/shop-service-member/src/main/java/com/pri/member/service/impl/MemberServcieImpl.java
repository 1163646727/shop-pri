package com.pri.member.service.impl;

import com.pri.entity.AppEntity;
import com.pri.member.feign.WeiXinServiceFeign;
import com.pri.member.service.MemberServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * className: MemberServcieImpl <BR>
 * description: <BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/2/16 22:44 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@RestController
public class MemberServcieImpl implements MemberServcie {

    /** 微信服务feign客户端，已经将微信所需微信接口的方法copy到feign客户端，直接同过feign调用 ChenQi*/
    @Autowired
    private WeiXinServiceFeign weiXinServiceFeign;


    @Override
    public AppEntity memberToWeiXin() {
        return weiXinServiceFeign.getAppEntity();
    }
}
