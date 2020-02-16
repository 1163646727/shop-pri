package com.pri.member.feign;

import com.pri.entity.AppEntity;
import com.pri.weixin.service.WeiXinService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * interfaceName: WeiXinServiceFeign <BR>
 * description: 微信服务feign客户端<BR>
 *     在feign注解中填入微信的注册id<BR>
 *     将feign继承微信服务，就可以用过WeiXinServiceFeign直接调用微信服务接口<BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/2/16 22:53 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@FeignClient("app-pri-weixin")
public interface WeiXinServiceFeign extends WeiXinService {

}
