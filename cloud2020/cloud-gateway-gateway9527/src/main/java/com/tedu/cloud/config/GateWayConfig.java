package com.tedu.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

/**
 * @Author: FJM
 * @Date 2022年01月11日 9:43
 * @Description: 网关配置
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();
        //通过and连接符将多个断言连接起来
        //可以有多个路由【.route()】
        builder.route("path_route_atguigu",
                        r->r.path("/guonei")
                                .and().method(HttpMethod.GET)//Path断言通过一个and连接符和method关联起来
                                .and().query("name","lisi")//参数匹配
                                .uri("http://news.baidu.com/guonei")
                )
                .build();
        return builder.build();
    }
}
