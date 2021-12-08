package com.tedu.cloud.service;

import com.tedu.cloud.entities.Payment;
import com.tedu.cloud.mapper.PaymentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: FJM
 * @Date 2021年12月08日 14:30
 * @Description: 支付服务
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
