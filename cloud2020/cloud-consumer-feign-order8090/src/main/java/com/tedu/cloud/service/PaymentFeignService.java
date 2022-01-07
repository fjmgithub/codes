package com.tedu.cloud.service;

import com.tedu.cloud.entities.CommonResult;
import com.tedu.cloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * @Author: FJM
 * @Date 2022年01月07日 16:20
 * @Description: feign调用
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("/provider/getPayment/{id}")
    CommonResult<Payment> getPayment (@PathVariable("id")Long id);

    @GetMapping("/provider/feignTimeout")
    String feignTimeout();
}
