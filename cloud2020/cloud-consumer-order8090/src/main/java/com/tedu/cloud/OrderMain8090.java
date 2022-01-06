package com.tedu.cloud;

import com.tedu.rule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @Author: FJM
 * @Date 2021年12月08日 16:00
 * @Description: 启动类
 */
@SpringBootApplication
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MyRibbonRule.class)//使用自定义负载均衡方式
public class OrderMain8090 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain8090.class,args);
    }
}
