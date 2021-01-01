package com.xishan.store.usercenter.userapi.model.response;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

@Data
public class UserLoginResponse implements Serializable {

    private Long id;

    private String userName;

    private String nickName;

    private Boolean gender;
    @DateTimeFormat(pattern =  "yyyy-MM-dd")
    private Date birthday;

    private String mobile;

    private String email;
    @DateTimeFormat(pattern =  "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @DateTimeFormat(pattern =  "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String passward;
}
