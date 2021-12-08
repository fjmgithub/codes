package com.tedu.cloud.controller;

import com.tedu.cloud.entities.CommonResult;
import com.tedu.cloud.entities.Payment;
import com.tedu.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: FJM
 * @Date 2021年12月06日 16:37
 * @Description: 支付模块
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/addPayment")
    public CommonResult<Payment> addPayment(Payment payment) {
        try {
            paymentService.addPayment(payment);
            return new CommonResult<>(200,"插入数据库成功！");
        } catch (Exception e) {
            return new CommonResult<>(400,"插入数据库失败！");
        }
    }

    @GetMapping(value = "/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        try {
            Payment payment = paymentService.getPayment(id);
            return new CommonResult<>(200,"获取支付信息成功！",payment);
        } catch (Exception e) {
            return new CommonResult<>(400,"获取支付信息失败！");
        }
    }
}
