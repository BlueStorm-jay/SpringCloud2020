package com.yun.springcloud.service.impl;

import com.yun.springcloud.dao.PaymentDao;
import com.yun.springcloud.entities.Payment;
import com.yun.springcloud.service.PaymentService;
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
