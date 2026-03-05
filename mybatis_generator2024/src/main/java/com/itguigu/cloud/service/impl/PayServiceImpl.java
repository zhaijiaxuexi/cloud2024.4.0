package com.itguigu.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itguigu.cloud.domain.Pay;
import com.itguigu.cloud.service.PayService;
import com.itguigu.cloud.mapper.PayMapper;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【t_pay(支付交易表)】的数据库操作Service实现
* @createDate 2026-02-13 13:59:34
*/
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay>
    implements PayService{

}




