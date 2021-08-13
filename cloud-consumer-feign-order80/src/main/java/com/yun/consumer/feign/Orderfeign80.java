package com.yun.consumer.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhouxingchao
 * @date 2021/8/10 16:22
 */
@SpringBootApplication
@EnableFeignClients
public class Orderfeign80 {
    public static void main(String[] args) {
        SpringApplication.run(Orderfeign80.class,args);
    }
}
