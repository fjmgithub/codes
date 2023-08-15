package com.tedu.cloud.controller;

import com.tedu.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author FJM
 * @Date 2022年01月10日 10:12
 * @Description hystrix
 */
@RestController
@RequestMapping("/hystrix")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @GetMapping("/getPaymentInfo/{id}")
    public String getPaymentInfo(@PathVariable("id") Long id){
        return paymentService.getPaymentInfo(id);
    }
    @GetMapping("/hystrixTimeout")
    public String hystrixTimeout(){
        return paymentService.hystrixTimeout();
    }

    @GetMapping("/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Long  id) {
        return paymentService.circuitBreaker(id);
    }

}
