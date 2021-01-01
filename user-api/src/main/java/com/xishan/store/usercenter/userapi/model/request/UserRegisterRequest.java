package com.xishan.store.usercenter.userapi.model.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
public class UserRegisterRequest implements Serializable {

    private Long id;

    private String userName;

    private String nickName;

    private Boolean gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String mobile;

    private String email;

    private String passward;
}
