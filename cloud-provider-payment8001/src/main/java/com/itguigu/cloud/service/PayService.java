package com.itguigu.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itguigu.cloud.domain.Pay;

/**
* @author admin
* @description 针对表【t_pay(支付交易表)】的数据库操作Service
* @createDate 2026-02-13 16:36:49
*/

public interface PayService extends IService<Pay> {

    String commonResource();
}
