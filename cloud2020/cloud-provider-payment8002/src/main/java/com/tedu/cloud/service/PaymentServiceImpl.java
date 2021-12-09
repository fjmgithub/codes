package com.tedu.cloud.service;

import com.tedu.cloud.entities.Payment;
import com.tedu.cloud.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: FJM
 * @Date 2021年09月07日 16:03
 * @Description: 支付
 */
@Service
public class PaymentServiceImpl implements PaymentService{
    @Resource
    private PaymentMapper paymentMapper;
    @Override
    public void addPayment(Payment payment) {
        paymentMapper.addPayment(payment);
    }

    @Override
    public Payment getPayment(Long id) {
        return paymentMapper.getPayment(id);
    }
}
