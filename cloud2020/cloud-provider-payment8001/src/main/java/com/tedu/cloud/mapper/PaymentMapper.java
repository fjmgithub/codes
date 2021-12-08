package com.tedu.cloud.mapper;

import com.tedu.cloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: FJM
 * @Date 2021年12月08日 14:31
 * @Description: 支付
 */
@Mapper
public interface PaymentMapper {
    int addPayment(Payment payment);

    Payment getPayment(@Param("id") Long id);
}
