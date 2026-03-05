package com.itguigu.cloud.resp;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ReturnCodeEnum {

    // --- 1. 枚举常量定义 ---

    /**操作失败**/
    RC999("999", "操作XXX失败"),
    /**操作成功**/
    RC200("200", "success"),
    /**服务降级**/
    RC201("201", "服务开启降级保护，请稍后再试!"),
    /**热点参数限流**/
    RC202("202", "热点参数限流，请稍后再试!"),
    /**系统规则不满足要求**/
    RC203("203", "系统规则不满足要求，请稍后再试!"),
    /**授权规则不通过**/
    RC204("204", "授权规则不通过，请稍后再试!"),
    /**access_denied**/
    RC403("403", "无访问权限，请联系管理员授予权限"),
    /**access_denied**/
    RC401("401", "匿名用户访问无权限资源时的异常"),
    /**页面找不到**/
    RC404("404", "404页面找不到的异常"),
    /**服务异常**/
    RC500("500", "系统异常，请稍后重试"),
    /**数字运算异常**/
    RC375("375", "数学运算异常，请稍后重试"),

    INVALID_TOKEN("2001", "访问令牌不合法"),
    ACCESS_DENIED("2003", "没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED("1001", "客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR("1002", "用户名或密码错误"),
    BUSINESS_ERROR("1004", "业务逻辑异常"),
    UNSUPPORTED_GRANT_TYPE("1003", "不支持的认证模式");

    // --- 2. 成员变量 ---

    /**自定义状态码**/
    private  String code;
    /**自定义描述**/
    private  String message;

    // --- 3. 构造方法 ---

    ReturnCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    // --- 4. 遍历枚举的方法 ---

    /**
     * 根据code获取对应的枚举对象 (V1版本: 传统for循环)
     */
    public static ReturnCodeEnum getReturnCodeEnum(String code) {
        for (ReturnCodeEnum element : ReturnCodeEnum.values()) {
            if (element.getCode().equalsIgnoreCase(code)) {
                return element;
            }
        }
        return null;
    }

    /**
     * 根据code获取对应的枚举对象 (V2版本: 使用Stream流，更现代的写法)
     */
    public static ReturnCodeEnum getReturnCodeEnumV2(String code) {
        return Arrays.stream(ReturnCodeEnum.values())
                .filter(x -> x.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
