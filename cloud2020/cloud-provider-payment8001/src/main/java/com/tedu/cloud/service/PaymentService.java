package com.tedu.cloud.service;

import com.tedu.cloud.entities.Payment;

/**
 * @Author: FJM
 * @Date 2021年12月08日 14:30
 * @Description: 支付服务
 */
public interface PaymentService {
    void addPayment(Payment payment);

    Payment getPayment(Long id);
}
