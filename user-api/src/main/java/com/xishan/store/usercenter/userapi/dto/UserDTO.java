package com.xishan.store.usercenter.userapi.dto;

import lombok.Data;

import java.io.Serializable;
@Data
public class UserDTO implements Serializable {

    private Long id;

    private String userName;

    private String nickName;

    private Boolean gender;
}
