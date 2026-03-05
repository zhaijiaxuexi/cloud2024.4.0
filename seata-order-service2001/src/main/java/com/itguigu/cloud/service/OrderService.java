package com.itguigu.cloud.service;

import com.itguigu.cloud.entities.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author admin
* @description 针对表【t_order】的数据库操作Service
* @createDate 2026-03-04 13:42:42
*/
public interface OrderService extends IService<Order> {

    /**
     * 创建订单
     * @param order
     */
    void create(Order order);
}
