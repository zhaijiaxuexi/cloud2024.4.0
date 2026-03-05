package com.itguigu.cloud.controller;

import com.itguigu.cloud.resp.ResultData;
import com.itguigu.cloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {



    @Autowired
    private StorageService storageService;


    @PostMapping("/storage/decrease")
    public ResultData decrease(@RequestParam Long productId, @RequestParam Integer count) {

        storageService.decrease(productId, count);
        return ResultData.success("扣减库存成功！");
    }
}
