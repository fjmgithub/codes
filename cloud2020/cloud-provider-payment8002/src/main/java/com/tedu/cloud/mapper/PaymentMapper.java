package com.tedu.cloud.mapper;

import com.tedu.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: FJM
 * @Date 2021年09月07日 15:54
 * @Description: 支付DAO
 */
@Mapper
public interface PaymentMapper {
    void addPayment(Payment payment);
    Payment getPayment(Long id);
}
