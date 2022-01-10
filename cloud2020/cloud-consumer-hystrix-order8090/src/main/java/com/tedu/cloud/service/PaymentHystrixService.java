package com.tedu.cloud.service;

import com.tedu.cloud.fallback.PaymentHystrixServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: FJM
 * @Date 2022年01月10日 14:23
 * @Description: hystrix服务降级
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceFallback.class)
public interface PaymentHystrixService {
    @GetMapping("/hystrix/getPaymentInfo/{id}")
    String getPaymentInfo(@PathVariable("id") Long id);

    @GetMapping("/hystrix/hystrixTimeout")
    String hystrixTimeout();

}
