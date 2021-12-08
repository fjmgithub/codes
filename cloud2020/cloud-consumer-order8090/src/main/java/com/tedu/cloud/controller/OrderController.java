package com.tedu.cloud.controller;

import com.tedu.cloud.entities.CommonResult;
import com.tedu.cloud.entities.Payment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: FJM
 * @Date 2021年12月08日 16:05
 * @Description: 订单模块
 */
@RestController
public class OrderController {
    public static final String GATEWAY = "http://localhost:8001";
    public static final String URI = "/payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/addPayment")
    public CommonResult<Payment> addPayment(Payment payment){
        String url = GATEWAY+URI+"addPayment";
        return doRequestService(payment,url);
    }

    @GetMapping("/consumer/getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        String url = GATEWAY+URI+"getPayment"+id;
        return doRequestService(new Payment(),url);
    }

    /**
     * @Author       FJM
     * @Date         2021/12/8 16:11
     * @Description  调用远程服务
     * @Param
     * @Return
     */
    private <T> CommonResult<T> doRequestService(T t, String url) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<T> httpEntity = new HttpEntity<>(t, headers);
        ParameterizedTypeReference<CommonResult<T>> typeRef =  new ParameterizedTypeReference<CommonResult<T>>(){};
        ResponseEntity<CommonResult<T>> response = restTemplate.exchange(url, HttpMethod.POST,httpEntity, typeRef);
        return response.getBody();
    }


}
