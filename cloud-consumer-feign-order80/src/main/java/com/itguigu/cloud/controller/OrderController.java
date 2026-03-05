package com.itguigu.cloud.controller;


import cn.hutool.core.util.RandomUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itguigu.cloud.api.PayFeignApi;
import com.itguigu.cloud.domain.Pay;
import com.itguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class OrderController {

    @Autowired
    private PayFeignApi payFeignApi;

    //新增
    @PostMapping(value = "/consumer/pays")
    public ResultData<Boolean> addOrder(@RequestBody Pay pay){
        return payFeignApi.save(pay);
    }

    //查询
    @GetMapping(value = "/consumer/pays/{id}")
    public ResultData<Pay> getPayInfo(@PathVariable Integer id){
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return payFeignApi.getById(id);

    }

    @GetMapping(value = "/consumer/pays")
    public ResultData<List<Pay>> getAllPayInfo(){
        return payFeignApi.getAll();
    }

    @GetMapping(value = "consumer/pays/testA")
    public ResultData<String> testA(){
        return payFeignApi.testA();
    }

    @GetMapping(value = "consumer/pays/testB")
    public ResultData<String> testB(){
        return payFeignApi.testB();
    }



    @GetMapping("consumer/pays/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "handler_HotKey")
    public String testHotKey(
            @RequestParam(value = "p1", required = false) String p1,
            @RequestParam(value = "p2", required = false) String p2)
    {
        return "------testHotKey 成功";
    }

    // 兜底方法
    public String handler_HotKey(String p1, String p2, BlockException exception) {
        return "------handler_HotKey，你点得太快了，被限流了！";
    }


}

