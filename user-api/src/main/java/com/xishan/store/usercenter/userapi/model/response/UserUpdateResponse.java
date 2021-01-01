package com.xishan.store.usercenter.userapi.model.response;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class UserUpdateResponse implements Serializable {
    private Long id;

    private String userName;

    private String nickName;

    private Boolean gender;

    private Date birthday;

    private String mobile;

    private String email;

    private Date createTime;

    private Date updateTime;
}
