package com.tedu.cloud.fallback;

import com.tedu.cloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author: FJM
 * @Date 2022年01月10日 15:54
 * @Description: 服务降级
 */
@Component
public class PaymentHystrixServiceFallback implements PaymentHystrixService {

    @Override
    public String getPaymentInfo(Long id) {
        return "getPaymentInfo() fallback: "+id;
    }

    @Override
    public String hystrixTimeout() {
        return "hystrixTimeout() fallback";
    }
}
