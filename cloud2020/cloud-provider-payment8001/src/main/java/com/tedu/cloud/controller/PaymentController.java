package com.tedu.cloud.controller;

import com.tedu.cloud.entities.CommonResult;
import com.tedu.cloud.entities.Payment;
import com.tedu.cloud.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: FJM
 * @Date 2021年12月06日 16:37
 * @Description: 支付模块
 */
@RestController
@RequestMapping(value = "/provider")
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;
    /**
     * @Author        FJM
     * @Date         2022/1/6 9:50
     * @Description  新增支付信息
     * @Param        [payment]
     * @Return       com.tedu.cloud.entities.CommonResult<com.tedu.cloud.entities.Payment>
     */
    @PostMapping(value = "/addPayment")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment) {
        try {
            paymentService.addPayment(payment);
            return new CommonResult<>(200,"插入数据库成功！端口："+serverPort);
        } catch (Exception e) {
            return new CommonResult<>(400,"插入数据库失败！端口："+serverPort);
        }
    }
    /**
     * @Author        FJM
     * @Date         2022/1/6 9:49
     * @Description  获取支付信息
     * @Param        [id]
     * @Return       com.tedu.cloud.entities.CommonResult<com.tedu.cloud.entities.Payment>
     */
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

    @GetMapping("/discovery")
    public Object discovery(){
        List<String> list = discoveryClient.getServices();
        for (String s : list) {
            String info = "serviceName = " + s;
            logger.info(info);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            String info = "host = " + instance.getHost()+", port = " + instance.getPort()+", uri = " + instance.getUri();
            logger.info(info);
        }
        return discoveryClient;
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
