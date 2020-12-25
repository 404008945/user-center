package com.xishan.store.usercenter.userserver.service;

import com.xishan.store.usercenter.userapi.model.User;
import com.xishan.store.usercenter.userserver.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }


    public int uodateUserById(User user){
        return userMapper.updateByPrimaryKey(user);
    }
}
