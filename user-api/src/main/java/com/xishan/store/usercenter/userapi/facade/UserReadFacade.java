package com.xishan.store.usercenter.userapi.facade;

import com.xishan.store.usercenter.userapi.dto.UserDTO;
import com.xishan.store.usercenter.userapi.model.User;
import com.xishan.store.usercenter.userapi.model.request.UserLoginRequest;
import com.xishan.store.usercenter.userapi.model.request.UserRegisterRequest;
import com.xishan.store.usercenter.userapi.model.response.UserLoginResponse;
import com.xishan.store.usercenter.userapi.model.response.UserRegisterResponse;

public interface UserReadFacade {
    UserDTO findById(Long Id);

    UserLoginResponse findByAccount(UserLoginRequest userLoginRequest);

    UserRegisterResponse register(UserRegisterRequest userRegisterRequest);
    
}
