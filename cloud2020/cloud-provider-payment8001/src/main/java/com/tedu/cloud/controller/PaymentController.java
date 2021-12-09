package com.tedu.cloud.controller;

import com.tedu.cloud.entities.CommonResult;
import com.tedu.cloud.entities.Payment;
import com.tedu.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: FJM
 * @Date 2021年12月06日 16:37
 * @Description: 支付模块
 */
@RestController
@RequestMapping(value = "/provider")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/addPayment")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment) {
        try {
            paymentService.addPayment(payment);
            return new CommonResult<>(200,"插入数据库成功！端口："+serverPort);
        } catch (Exception e) {
            return new CommonResult<>(400,"插入数据库失败！端口："+serverPort);
        }
    }

    @GetMapping(value = "/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        try {
            Payment payment = paymentService.getPayment(id);
            if(payment==null){
                return new CommonResult<>(200,"没有查到订单信息！端口："+serverPort);
            }
            return new CommonResult<>(200,"OK！端口："+serverPort,payment);
        } catch (Exception e) {
            return new CommonResult<>(400,"获取支付信息失败！端口："+serverPort);
        }
    }
}
