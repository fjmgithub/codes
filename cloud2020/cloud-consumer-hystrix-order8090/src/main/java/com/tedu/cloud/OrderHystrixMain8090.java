package com.tedu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: FJM
 * @Date 2022年01月10日 14:19
 * @Description: 启动类
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain8090 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain8090.class,args);
    }
}
