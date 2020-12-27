package com.xishan.store.usercenter.userapi.model.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserUpdateResponse implements Serializable {
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
