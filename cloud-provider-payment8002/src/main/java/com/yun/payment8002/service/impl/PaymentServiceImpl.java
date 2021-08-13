package com.yun.payment8002.service.impl;


import com.yun.payment8002.dao.PaymentDao;
import com.yun.payment8002.service.PaymentService;
import com.yun.springcloud.entities.Payment;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhouxingchao
 * @date 2021/8/6 9:30
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
