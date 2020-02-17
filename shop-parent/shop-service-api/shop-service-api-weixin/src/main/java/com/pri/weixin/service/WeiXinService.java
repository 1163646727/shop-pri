package com.pri.weixin.service;

import com.pri.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * interfaceName: WeiXinService <BR>
 * description: 微信服务接口<BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/2/16 21:52 <BR>
 * version 1.0 jdk1.8 <BR>
 */
@Api(tags = "微信服务接口")
public interface WeiXinService {
    /**
     * description: 项目会集成swarget，使用RequestMapping也会做映射，与swarget会冲突
     * author: ChenQi <BR>
     * createDate: 2020-02-16 21:54  <BR>
     */
    @ApiOperation(value = "获取App实体信息")
    @GetMapping("/getAppEntity")
    public AppEntity getAppEntity();
}
