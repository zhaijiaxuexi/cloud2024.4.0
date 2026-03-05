package com.itguigu.cloud.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class MyRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        // 1. 我们约定：请求头里带一个 serverName 字段来代表身份
        String origin = httpServletRequest.getHeader("serverName");

        System.out.println("Sentinel 识别到的来源是：" + origin);

        // 2. 如果没传，就给它一个默认身份 "unknown"
        return origin == null ? "unknown" : origin;
    }
}
