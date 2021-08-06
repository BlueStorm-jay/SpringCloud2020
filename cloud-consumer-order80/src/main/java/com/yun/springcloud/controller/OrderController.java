package com.yun.springcloud.controller;


import com.yun.springcloud.entities.CommonResult;
import com.yun.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhouxingchao
 * @date 2021/8/6 13:10
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(
                PAYMENT_URL+"/payment",payment,CommonResult.class
        );
    }
    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(
                PAYMENT_URL+"/payment/"+id,CommonResult.class);
    }
}
