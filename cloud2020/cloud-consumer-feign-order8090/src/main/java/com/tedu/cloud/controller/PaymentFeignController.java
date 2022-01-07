package com.tedu.cloud.controller;

import com.tedu.cloud.entities.CommonResult;
import com.tedu.cloud.entities.Payment;
import com.tedu.cloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: FJM
 * @Date 2022年01月07日 16:20
 * @Description: 控制层
 */
@RestController
@RequestMapping("/feign")
public class PaymentFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping("/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }

    @GetMapping("/feignTimeout")
    public String feignTimeout(){
       return paymentFeignService.feignTimeout();
    }
}
