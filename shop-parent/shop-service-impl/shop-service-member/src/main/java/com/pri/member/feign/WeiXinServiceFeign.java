package com.pri.member.feign;

import com.pri.entity.AppEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * interfaceName: WeiXinServiceFeign <BR>
 * description: 微信服务feign客户端<BR>
 *     在feign注解中填入微信的注册id<BR>
 *     将微信服务的方法copy进来，就可以用过WeiXinServiceFeign直接调用微信服务接口<BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/2/16 22:53 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@FeignClient("app-pri-weixin")
public interface WeiXinServiceFeign {
    /**
     * description: 项目会集成swarget，使用RequestMapping也会做映射，与swarget会冲突
     * author: ChenQi <BR>
     * createDate: 2020-02-16 21:54  <BR>
     */
    @GetMapping("/getAppEntity")
    public AppEntity getAppEntity();
}
