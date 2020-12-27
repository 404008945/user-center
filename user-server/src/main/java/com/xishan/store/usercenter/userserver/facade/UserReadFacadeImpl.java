package com.xishan.store.usercenter.userserver.facade;

import com.xishan.store.usercenter.userapi.dto.UserDTO;
import com.xishan.store.usercenter.userapi.facade.UserReadFacade;
import com.xishan.store.usercenter.userapi.model.User;
import com.xishan.store.usercenter.userapi.model.request.UserLoginRequest;
import com.xishan.store.usercenter.userapi.model.request.UserRegisterRequest;
import com.xishan.store.usercenter.userapi.model.response.UserLoginResponse;
import com.xishan.store.usercenter.userapi.model.response.UserRegisterResponse;
import com.xishan.store.usercenter.userserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Slf4j
public class UserReadFacadeImpl  implements UserReadFacade {

    @Autowired
    private UserService userService;

    @Override
    public UserDTO findById(Long id) {
        log.info("服务调用");
        User user  = userService.findById(id);
        UserDTO  userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    @Override
    public UserLoginResponse findByAccount(UserLoginRequest userLoginRequest) {
        User user = userService.findByAccount(userLoginRequest);//登录可能查不到
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        BeanUtils.copyProperties(user,userLoginResponse);
        return userLoginResponse;
    }

    @Override
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest) {
        return userService.register(userRegisterRequest);
    }
}
