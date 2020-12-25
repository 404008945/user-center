package com.xishan.store.usercenter.userserver;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDubbo
@EnableTransactionManagement
public class UserServerStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServerStarterApplication.class, args);
    }

}