package com.xishan.store.usercenter.userapi.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginRequest implements Serializable {

    /**
     * 用户账户
     */
    private String userName;

    /**
     * 用户密码
     */
    private String passward;


}
