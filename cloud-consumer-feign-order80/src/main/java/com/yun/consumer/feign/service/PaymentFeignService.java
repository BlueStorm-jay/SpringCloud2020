package com.yun.consumer.feign.service;

import com.yun.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhouxingchao
 * @date 2021/8/10 16:27
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@RequestMapping("/payment")
public interface PaymentFeignService {

    @GetMapping(value = "/{id}")
    CommonResult getPaymentById(@PathVariable("id") Long id);

}
