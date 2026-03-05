package com.itguigu.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itguigu.cloud.api.AccountFeignApi;
import com.itguigu.cloud.api.StorageFeignApi;
import com.itguigu.cloud.entities.Order;
import com.itguigu.cloud.service.OrderService;
import com.itguigu.cloud.mapper.OrderMapper;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author admin
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2026-03-04 13:42:42
*/

@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private StorageFeignApi storageFeignApi;
    @Autowired
    private AccountFeignApi accountFeignApi;

    /**
     * 创建订单 - 分布式事务测试
     * 下单 -> 扣库存 -> 扣余额 -> 改状态
     */
    @Override
    @GlobalTransactional(name = "create-order-flow", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-----> 开始新建订单");
        orderMapper.insert(order);

        log.info("-----> 订单微服务开始调用库存，做扣减Count");
        storageFeignApi.decrease(order.getProductId(), order.getCount());

        log.info("-----> 订单微服务开始调用账户，做扣减Money");
        accountFeignApi.decrease(order.getUserId(), order.getMoney());

        log.info("-----> 修改订单状态开始");
        //下面两行是我自己加的。ai不知道我用了mp，ai以为orderMapper是我自定义的。
        order.setStatus(0);
        orderMapper.updateById(order);
//        orderMapper.updateStatus(order.getUserId(), 0);
        log.info("-----> 下单业务结束");
    }
}




