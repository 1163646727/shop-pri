package com.pri.weixin.service;

import com.pri.entity.AppEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * interfaceName: WeiXinService <BR>
 * description: 微信服务接口<BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/2/16 21:52 <BR>
 * version 1.0 jdk1.8 <BR>
 */
public interface WeiXinService {
    /**
     * description: 项目会集成swarget，使用RequestMapping也会做映射，与swarget会冲突
     * author: ChenQi <BR>
     * createDate: 2020-02-16 21:54  <BR>
     */
    @GetMapping("/getAppEntity")
    public AppEntity getAppEntity();
}
