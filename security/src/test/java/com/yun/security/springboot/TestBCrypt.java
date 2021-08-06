package com.yun.security.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhouxingchao
 * @date 2021/8/4 10:20
 */
@RunWith(SpringRunner.class)
public class TestBCrypt {
    @Test
    public void testBCrypt(){
        ////对密码进行加密
        //String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        //System.out.println(hashpw);
        //校验密码
        boolean checkpw = BCrypt.checkpw("123", "$2a$10$e9kRsIHMaf6WvtCfdjumE.CdmEOVKtyLkxqfqxuB/c1Mmonv9WP8e");
        System.out.println(checkpw);
        //$2a$10$H.Mg5f0tunIAVVcxYxJ6nuWl64690gsOO1R9WUMfuelIyNlfo11/u
    }
}
