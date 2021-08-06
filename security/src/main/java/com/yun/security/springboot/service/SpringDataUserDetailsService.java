package com.yun.security.springboot.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhouxingchao
 * @date 2021/8/4 9:53
 */
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //暂时采用模拟方式
        System.out.println("username" + username);
        UserDetails userDetails = User.withUsername("zhangsan")
                .password("$2a$10$e9kRsIHMaf6WvtCfdjumE.CdmEOVKtyLkxqfqxuB/c1Mmonv9WP8e")
                .authorities("p1").build();
        return userDetails;
    }
}
