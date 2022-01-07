package com.tedu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: FJM
 * @Date 2022年01月07日 15:17
 * @Description: 启动类
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain8090 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain8090.class,args);
    }
}
