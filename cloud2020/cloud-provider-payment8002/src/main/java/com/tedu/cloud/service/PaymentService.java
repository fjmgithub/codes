package com.tedu.cloud.service;

import com.tedu.cloud.entities.Payment;

/**
 * @Author: FJM
 * @Date 2021年09月07日 16:03
 * @Description: 支付
 */
public interface PaymentService {
    void addPayment(Payment payment);
    Payment getPayment(Long id);
}
