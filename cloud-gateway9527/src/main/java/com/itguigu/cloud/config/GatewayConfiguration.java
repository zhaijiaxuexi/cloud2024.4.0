package com.itguigu.cloud.config; // 确认包名是否一致

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.annotation.PostConstruct;

@Configuration
public class GatewayConfiguration {

    @PostConstruct
    public void doInit() {
        // 定义限流后的返回逻辑
        BlockRequestHandler handler = (exchange, t) -> {
            return ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue("{\"code\":429,\"msg\":\"网关提示：流量过大，请稍后再试！\"}"));
        };

        // 【关键修正】：使用 GatewayCallbackManager 来注册
        GatewayCallbackManager.setBlockHandler(handler);
    }
}