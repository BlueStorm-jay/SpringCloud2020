package com.yun.payment8002.controller;

import com.yun.payment8002.service.PaymentService;
import com.yun.springcloud.entities.CommonResult;
import com.yun.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author zhouxingchao
 * @date 2021/8/6 9:33
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("-----\n\n插入结果:" + result+"\n\n------");
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功"+serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败"+serverPort, null);
        }
    }

    @GetMapping(value = "/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("-----\n\n查询结果:" + result+"\n\n------");
        if (result != null) {
            return new CommonResult(200, "查询成功"+serverPort, result);
        } else {
            return new CommonResult(444, "没有对应记录,查询id"+id+serverPort, null);
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }
}
