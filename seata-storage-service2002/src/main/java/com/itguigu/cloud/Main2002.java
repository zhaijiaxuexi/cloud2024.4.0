package com.itguigu.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@MapperScan("com.itguigu.cloud.mapper")
@SpringBootApplication
@EnableDiscoveryClient // 开启服务发现
@EnableFeignClients
public class Main2002 {

    public static void main(String[] args) {

        SpringApplication.run(Main2002.class,args);
    }
}