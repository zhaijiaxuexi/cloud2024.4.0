package com.itguigu.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResultData <T>{


    private String code;    /** 结果状态码，具体状态码参见枚举类ReturnCodeEnum.java **/
    private String message; /** 响应消息 **/
    private T data;         /** 响应数据 **/
    private long timestamp; /** 接口调用时间戳 **/

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功执行的静态工厂方法
     */
    public static <T> ResultData<T> success(T data) {

        return new ResultData<T>()
                .setCode(ReturnCodeEnum.RC200.getCode())
                .setMessage(ReturnCodeEnum.RC200.getMessage())
                .setData(data);
    }

    /**
     * 失败执行的静态工厂方法
     */
    public static <T> ResultData<T> fail(ReturnCodeEnum returnCodeEnum) {

        return new ResultData<T>()
                .setCode(returnCodeEnum.getCode())
                .setMessage(returnCodeEnum.getMessage())
                .setData(null);
    }
}
