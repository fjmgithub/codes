package com.tedu.cloud.controller;

import com.tedu.cloud.entities.CommonResult;
import com.tedu.cloud.entities.Payment;
import com.tedu.cloud.service.LoadBalances;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: FJM
 * @Date 2021年12月08日 16:05
 * @Description: 订单模块
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {
//    public static final String GATEWAY = "http://localhost:8001"
    public static final String GATEWAY = "http://CLOUD-PAYMENT-SERVICE";
    public static final String URI = "/provider";
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private LoadBalances loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/addPayment")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment){
        String url = GATEWAY+URI+"/addPayment";
        return doRequestService(payment,url,HttpMethod.POST);
    }

    @GetMapping("getPayment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        String url = GATEWAY+URI+"/getPayment/"+id;
        return doRequestService(new Payment(),url,HttpMethod.GET);
    }

    /**
     * @Author       FJM
     * @Date         2021/12/8 16:11
     * @Description  调用远程服务
     * @Param
     * @Return
     */
    private <T> CommonResult<T> doRequestService(T t, String url,HttpMethod httpMethod) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<T> httpEntity = new HttpEntity<>(t, headers);
        ParameterizedTypeReference<CommonResult<T>> typeRef =  new ParameterizedTypeReference<CommonResult<T>>(){};
        ResponseEntity<CommonResult<T>> response = restTemplate.exchange(url, httpMethod,httpEntity, typeRef);
        return response.getBody();
    }

    @GetMapping(value = "/testMyRoundRobin")
    public String testMyRoundRobin() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.isEmpty()) {
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        java.net.URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/provider/testMyRoundRobin", String.class);
    }

}
