package com.yun.springcloud.service;

import com.yun.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhouxingchao
 * @date 2021/8/6 9:29
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
