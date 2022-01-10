package com.tedu.cloud.controller;

import com.tedu.cloud.service.PaymentHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: FJM
 * @Date 2022年01月10日 14:31
 * @Description: hystrix服务降级
 */
@RestController
@RequestMapping("/hystrix")
//@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/getPaymentInfo/{id}")
    public String getPaymentInfo(@PathVariable("id") Long id){
        return paymentHystrixService.getPaymentInfo(id);
    }

//    @HystrixCommand(fallbackMethod = "hystrixFallbackMethod",
//            commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
//    @HystrixCommand
    @GetMapping("/hystrixTimeout")
    public String hystrixTimeout(){
        return paymentHystrixService.hystrixTimeout();
    }

//    public String hystrixFallbackMethod(){
//        return "hystrix8090服务繁忙！！！";
//    }
//
//    public String globalFallbackMethod(){
//        return "hystrix8090服务繁忙！！！(global)";
//    }
}
