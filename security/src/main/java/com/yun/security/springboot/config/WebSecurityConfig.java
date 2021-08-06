package com.yun.security.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author zhouxingchao
 * @date 2021/8/3 15:49
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //查询用户信息
    //@Bean
    //public UserDetailsService userDetailsService(){
    //    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
    //    manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
    //    manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
    //    return manager;
    //}

    //密码编码器
    //@Bean
    //public PasswordEncoder passwordEncoder(){
    //    return NoOpPasswordEncoder.getInstance();
    //}

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //配置安全拦截机制
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/r/r1").hasAnyAuthority("p1")
                .antMatchers("/r/r2").hasAnyAuthority("p2")
                .antMatchers("/r/**").authenticated()   //所有/r/**的请求必需认证通过
                .anyRequest().permitAll()  //除了/r/**,其他的请求可以访问
                .and().formLogin()  //允许表单登录
                .successForwardUrl("/login-success");   //自定义登录成功的页面地址
    }
}
