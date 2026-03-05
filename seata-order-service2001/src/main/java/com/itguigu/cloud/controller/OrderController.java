package com.itguigu.cloud.controller;

import com.itguigu.cloud.entities.Order;
import com.itguigu.cloud.resp.ResultData;
import com.itguigu.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/decrease")
    public ResultData decrease(@RequestBody Order order) {


        orderService.create(order);
        return ResultData.success("扣减库存成功！");
    }
}
