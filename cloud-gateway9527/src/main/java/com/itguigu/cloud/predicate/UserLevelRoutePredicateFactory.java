package com.itguigu.cloud.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

// 1. 必须加 @Component 交给 Spring 管理
@Component
public class UserLevelRoutePredicateFactory extends AbstractRoutePredicateFactory<UserLevelRoutePredicateFactory.Config> {

    public UserLevelRoutePredicateFactory() {
        super(Config.class);
    }

    // 2. 这个方法用于支持 yml 里的简写（快捷配置）
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userLevel");
    }

    // 3. 核心逻辑：判断请求是否符合条件
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            // 获取 URL 中的参数 userLevel
            String userLevel = exchange.getRequest().getQueryParams().getFirst("userLevel");

            // 逻辑判断：如果参数值等于 yml 中配置的值，则放行
            if (config.getUserLevel().equalsIgnoreCase(userLevel)) {
                return true; // 匹配成功，放行
            }
            return false; // 匹配失败，拦截
        };
    }

    // 4. 内部配置类，用于接收 yml 传来的参数
    public static class Config {
        private String userLevel;
        public String getUserLevel() { return userLevel; }
        public void setUserLevel(String userLevel) { this.userLevel = userLevel; }
    }
}