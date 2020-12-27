package com.xishan.store.usercenter.userweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class UserWebStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserWebStarterApplication.class, args);
    }

}
