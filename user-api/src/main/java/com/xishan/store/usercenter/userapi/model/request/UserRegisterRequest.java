package com.xishan.store.usercenter.userapi.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterRequest implements Serializable {

    private Long id;

    private String userName;

    private String nickName;

    private Boolean gender;

    private Long birthday;

    private String mobile;

    private String email;

    private String passward;
}
