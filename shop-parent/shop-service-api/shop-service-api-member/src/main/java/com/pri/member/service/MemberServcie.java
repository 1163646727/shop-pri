package com.pri.member.service;

import com.pri.entity.AppEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * interfaceName: MemberServcie <BR>
 * description: 会员服务接口<BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/2/16 22:38 <BR>
 * version 1.0 jdk1.8 <BR>
 */
public interface MemberServcie {
    @GetMapping("/memberServcie")
    public AppEntity memberToWeiXin();
}
