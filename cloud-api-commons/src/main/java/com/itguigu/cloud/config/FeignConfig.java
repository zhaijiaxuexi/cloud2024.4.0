package com.itguigu.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel() {
        // 这里有四种级别：
        // 1. NONE：默认的，什么都不印。
        // 2. BASIC：仅记录请求方法、URL、响应状态码及执行时间（推荐生产环境用，节省空间）。
        // 3. HEADERS：在BASIC的基础上，记录请求和响应的头信息。
        // 4. FULL：最全的。记录请求和响应的头信息、正文(Body)和元数据（开发调试必用！）。
        return Logger.Level.FULL;
    }
}