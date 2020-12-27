package com.xishan.store.usercenter.userweb.vo;

import lombok.Data;

@Data
public class LoginResponseVO {
    private Long id;

    private String userName;

    private String nickName;

    private Boolean gender;

    private Long birthday;

    private String mobile;

    private String email;

    private Integer createTime;

    private Integer updateTime;

}
