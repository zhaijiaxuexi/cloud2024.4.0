package com.itguigu.cloud.service;

import com.itguigu.cloud.domain.Pay;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RubbishTest {


    @Autowired
    private PayService payService;

    @Test
    public void rubbishTest(){

        Pay pay = new Pay();
        pay.setPayNo("111");
        pay.setOrderNo("222");
        payService.save(pay);
    }

}
