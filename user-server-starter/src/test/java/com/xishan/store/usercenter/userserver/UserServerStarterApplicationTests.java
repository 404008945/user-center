package com.xishan.store.usercenter.userserver;

import com.xishan.store.usercenter.userserver.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServerStarterApplicationTests {

    @Autowired
    private UserService userReadFacade;

    @Test
    void contextLoads() {
        userReadFacade.findById(1l);
    }

}
