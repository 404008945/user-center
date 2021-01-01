package com.xishan.store.usercenter.userapi.model.request;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserUpdateRequest implements Serializable {


    private String nickName;

    private Boolean gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String mobile;

    private String email;

}
