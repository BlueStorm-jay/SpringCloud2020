package com.yun.consumer.feign.controller;

import com.yun.consumer.feign.service.PaymentFeignService;
import com.yun.springcloud.entities.CommonResult;
import com.yun.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhouxingchao
 * @date 2021/8/10 16:35
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){

    }
}
