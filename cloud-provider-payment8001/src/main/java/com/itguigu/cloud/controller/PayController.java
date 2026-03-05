package com.itguigu.cloud.controller;


import com.itguigu.cloud.domain.Pay;
import com.itguigu.cloud.resp.ResultData;
import com.itguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/pays")
@Tag(name = "支付微服务模块",description = "支付的CRUD")
public class PayController {

    @Autowired
    private PayService payService;



    @GetMapping("{id}")
    @Operation(summary = "查询单条数据",description = "查询支付流水方法")
    public ResultData<Pay> getById(@PathVariable Integer id){
        return ResultData.success(payService.getById(id));
//        return payService.getById(id);

    }

    @PostMapping
    @Operation(summary = "新增单条数据",description = "新增支付流水方法，json做参数")
    public ResultData<Boolean> save(@RequestBody Pay pay){
        return ResultData.success(payService.save(pay));
//        return payService.save(pay);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "删除单条数据",description = "删除支付流水方法")
    public ResultData<Boolean> delete(@PathVariable Integer id){
        return ResultData.success(payService.removeById(id));
//        return payService.removeById(id);
    }

    @PutMapping
    @Operation(summary = "更新单条数据",description = "修改支付流水方法")
    public ResultData<Boolean> update(@RequestBody Pay pay){
        return ResultData.success(payService.updateById(pay));
//        return payService.updateById(pay);
    }

    @GetMapping
    @Operation(summary = "查询全部数据",description = "查询支付流水方法")
    public ResultData<List<Pay>> getAll(){

//        System.out.println(System.currentTimeMillis());

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ResultData.success(payService.list());
//        return payService.list();
    }

    @GetMapping("testA")
    public ResultData<String> testA(){
        return ResultData.success(payService.commonResource());
    }

    @GetMapping("testB")
    public ResultData<String> testB(){
        return ResultData.success(payService.commonResource());
    }


    //测试gateway的filter功能
    @GetMapping(value = "/gateway/filter")
    public ResultData<String> getGatewayFilter(HttpServletRequest request)
    {
        String result = "";
        // 1. 获取请求中所有的请求头名称
        java.util.Enumeration<String> headers = request.getHeaderNames();

        // 2. 遍历请求头
        while(headers.hasMoreElements())
        {
            String headName = headers.nextElement();
            String headValue = request.getHeader(headName);

            // 在控制台打印，方便调试查看
            System.out.println("请求头名: " + headName + "\t\t" + "请求头值: " + headValue);

            // 3. 这里的逻辑是：如果请求头里包含我们在网关配置的自定义头信息，就把它拼接到返回结果里
            if(headName.equalsIgnoreCase("X-Request-atguigu1")
                    || headName.equalsIgnoreCase("X-Request-atguigu2")) {
                result = result + headName + "\t " + headValue + " ";
            }
        }

        System.out.println("==========================================");
        String customerId1 = request.getParameter("customerId1");
        System.out.println("customerId1 = " + customerId1);
        System.out.println("==========================================");
        String customerId2 = request.getParameter("customerId2");
        System.out.println("customerId2 = " + customerId2);

        // 4. 返回结果，包含拼接的头信息和当前时间
        return ResultData.success("getGatewayFilter 过滤器 test: " + result + " \t " + cn.hutool.core.date.DateUtil.now());
    }
}
