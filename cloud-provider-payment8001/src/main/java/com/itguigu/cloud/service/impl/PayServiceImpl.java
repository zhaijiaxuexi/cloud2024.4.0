package com.itguigu.cloud.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itguigu.cloud.domain.Pay;
import com.itguigu.cloud.service.PayService;
import com.itguigu.cloud.mapper.PayMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【t_pay(支付交易表)】的数据库操作Service实现
* @createDate 2026-02-13 16:36:49
*/
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay> implements PayService{

    // 定义一个名为 "commonResource" 的资源
    @Override
    @SentinelResource("commonResource")
    public String commonResource() {
//        System.out.println("--- 正在处理核心业务逻辑，测试流控模式的链路 ---");
        return "--- 正在处理核心业务逻辑，测试流控模式的链路 ---";
    }

}




