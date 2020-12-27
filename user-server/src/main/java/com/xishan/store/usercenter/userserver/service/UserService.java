package com.xishan.store.usercenter.userserver.service;

import com.xishan.store.usercenter.userapi.model.User;
import com.xishan.store.usercenter.userapi.model.request.UserLoginRequest;
import com.xishan.store.usercenter.userapi.model.request.UserRegisterRequest;
import com.xishan.store.usercenter.userapi.model.response.UserLoginResponse;
import com.xishan.store.usercenter.userapi.model.response.UserRegisterResponse;
import com.xishan.store.usercenter.userserver.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }


    public int updateUserById(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User findByAccount(UserLoginRequest userLoginRequest){
        return userMapper.selectByAccount(userLoginRequest);
    }

    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest){
        User user = new User();
        BeanUtils.copyProperties(userRegisterRequest,user);
        int ans =  userMapper.insertSelective(user);
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setIsSuccess(false);
        if(ans == 1){
            userRegisterResponse.setIsSuccess(true);
        }
        return userRegisterResponse;
    }
}
