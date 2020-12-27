package com.xishan.store.usercenter.userweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.xishan.store.usercenter.userweb.util.RedisUtil;

@SpringBootTest
class UserWebStarterApplicationTests {
    @Autowired
    RedisUtil redisUtil;




    @Test
    public void contextLoads() {


        System.out.println( redisUtil.get("dog"));

    }
}
