package com.yun.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhouxingchao
 * @date 2021/8/6 13:14
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced   //开启负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}


