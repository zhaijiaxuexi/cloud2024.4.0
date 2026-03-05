package com.itguigu.cloud.api;

import com.itguigu.cloud.domain.Pay;
import com.itguigu.cloud.resp.ResultData;
import com.itguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PayFeignApiFallback implements PayFeignApi{
    @Override
    public ResultData<Pay> getById(Integer id) {
        return ResultData.fail(ReturnCodeEnum.RC500);
    }

    @Override
    public ResultData<Boolean> save(Pay pay) {
        return ResultData.fail(ReturnCodeEnum.RC500);
    }

    @Override
    public ResultData<Boolean> delete(Integer id) {
        return ResultData.fail(ReturnCodeEnum.RC500);
    }

    @Override
    public ResultData<Boolean> update(Pay pay) {
        return ResultData.fail(ReturnCodeEnum.RC500);
    }

    @Override
    public ResultData<List<Pay>> getAll() {
        return ResultData.fail(ReturnCodeEnum.RC500);
    }

    @Override
    public ResultData<String> testA() {
        return ResultData.fail(ReturnCodeEnum.RC500);
    }

    @Override
    public ResultData<String> testB() {
        return ResultData.fail(ReturnCodeEnum.RC500);
    }
}
