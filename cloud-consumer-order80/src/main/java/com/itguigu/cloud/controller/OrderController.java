package com.itguigu.cloud.controller;


import cn.hutool.core.util.RandomUtil;
import com.itguigu.cloud.domain.Pay;
import com.itguigu.cloud.domain.PayDTO;
import com.itguigu.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private DiscoveryClient discoveryClient;

    public static final String PaymentSrv_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    //新增
    @PostMapping(value = "/consumer/pays")
    public ResultData<Boolean> addOrder(@RequestBody Pay pay){

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance instance = instances.get(RandomUtil.randomInt(instances.size()));
        URI uri = instance.getUri();

//        return restTemplate.postForObject(PaymentSrv_URL + "/pays",pay,ResultData.class);
        return restTemplate.postForObject(uri + "/pays",pay,ResultData.class);
    }

    //查询
    @GetMapping(value = "/consumer/pays/{id}")
    public ResultData<Pay> getPayInfo(@PathVariable Integer id){

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance instance = instances.get(RandomUtil.randomInt(instances.size()));
        URI uri = instance.getUri();

//        return restTemplate.getForObject(PaymentSrv_URL + "/pays/{id}",ResultData.class,id);
        return restTemplate.getForObject(uri + "/pays/{id}",ResultData.class,id);
    }




}
