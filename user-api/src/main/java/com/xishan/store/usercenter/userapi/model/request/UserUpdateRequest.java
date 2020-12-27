package com.xishan.store.usercenter.userapi.model.request;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserUpdateRequest implements Serializable {

    private Long id;

    private String nickName;

    private Boolean gender;

    private Long birthday;

    private String mobile;

    private String email;

}
