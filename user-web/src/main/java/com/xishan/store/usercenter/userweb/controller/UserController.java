package com.xishan.store.usercenter.userweb.controller;

import com.xishan.store.usercenter.userapi.facade.UserReadFacade;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/user")
public class UserController {
    @Reference
    private UserReadFacade userReadFacade;


    @GetMapping("/")
    @ResponseBody
    public String index(){
        return userReadFacade.findById(1l).toString();
    }


}
