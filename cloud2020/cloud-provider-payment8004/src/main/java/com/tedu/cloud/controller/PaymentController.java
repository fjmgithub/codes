package com.tedu.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: FJM
 * @Date 2022年01月06日 11:13
 * @Description: 注册zookeeper
 */
@RestController
@RequestMapping("payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/paymentZk")
    public String paymentZk() {
        return "springCloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID();
    }
}
