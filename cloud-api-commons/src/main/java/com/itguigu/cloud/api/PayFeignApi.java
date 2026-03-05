package com.itguigu.cloud.api;

import com.itguigu.cloud.config.FeignConfig;
import com.itguigu.cloud.domain.Pay;
import com.itguigu.cloud.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "cloud-payment-service",configuration = FeignConfig.class,fallback = PayFeignApiFallback.class)
public interface PayFeignApi {

    @GetMapping("/pays/{id}")
    public ResultData<Pay> getById(@PathVariable("id") Integer id);

    @PostMapping("/pays")
    public ResultData<Boolean> save(@RequestBody Pay pay);

    @DeleteMapping("/pays/{id}")
    public ResultData<Boolean> delete(@PathVariable("id") Integer id);

    @PutMapping("/pays")
    public ResultData<Boolean> update(@RequestBody Pay pay);

    @GetMapping("/pays")
    public ResultData<List<Pay>> getAll();

    @GetMapping("/pays/testA")
    public ResultData<String> testA();

    @GetMapping("/pays/testB")
    public ResultData<String> testB();




}
