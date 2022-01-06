package com.tedu.cloud.controller;

import com.tedu.cloud.entities.CommonResult;
import com.tedu.cloud.entities.Payment;
import com.tedu.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: FJM
 * @Date 2021年12月09日 16:06
 * @Description: 支付
 */
@RestController
@RequestMapping("/provider")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    /**
     * @Author       FJM
     * @Date         2021/12/9 16:37
     * @Description  新增支付信息
     * @Param
     * @Return 
     */
    @PostMapping("/addPayment")
    public CommonResult<String> addPayment(@RequestBody Payment payment){
        try {
            paymentService.addPayment(payment);
            return new CommonResult<>(200,"插入数据库成功,serverPort: "+serverPort);
        }catch (RuntimeException e){
            return new CommonResult<>(400,"新增失败！serverPort: "+serverPort);
        }
    }
    /**
     * @Author       FJM
     * @Date         2021/12/9 16:42
     * @Description  获取支付信息
     * @Param
     * @Return
     */
    @GetMapping(value = "/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        try {
            Payment payment = paymentService.getPayment(id);
            if(payment==null){
                return new CommonResult<>(200,"没有查到订单信息！serverPort: "+serverPort);
            }
            return new CommonResult<>(200,"OK！,serverPort: "+serverPort,payment);
        }catch (Exception e){
            return new CommonResult<>(400,"查询失败！serverPort: "+serverPort);
        }
    }
    /**
     * @Author        FJM
     * @Date         2022/1/6 16:31
     * @Description  测试手写轮询
     * @Param        []
     * @Return       java.lang.String
     */
    @GetMapping("/testMyRoundRobin")
    public String testMyRoundRobin(){
        return serverPort;
    }
}
