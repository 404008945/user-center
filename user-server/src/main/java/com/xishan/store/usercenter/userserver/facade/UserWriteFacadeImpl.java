package com.xishan.store.usercenter.userserver.facade;

import com.xishan.store.usercenter.userapi.facade.UserWriteFacade;
import com.xishan.store.usercenter.userapi.model.User;
import com.xishan.store.usercenter.userapi.model.request.UserUpdateRequest;
import com.xishan.store.usercenter.userapi.model.response.UserUpdateResponse;
import com.xishan.store.usercenter.userserver.service.UserService;
import exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
@Service
@Slf4j
public class UserWriteFacadeImpl implements UserWriteFacade {

    @Autowired
    private UserService userService;
    @Override
    public UserUpdateResponse update(UserUpdateRequest userUpdateRequest) {//先更新，再查找

        User record = new User();
        BeanUtils.copyProperties(userUpdateRequest,record);
        if(userService.updateUserById(record)<=0){
            throw new ServiceException("更新失败");
        }
        User user = userService.findById(userUpdateRequest.getId());
        UserUpdateResponse userUpdateResponse = new UserUpdateResponse();
        BeanUtils.copyProperties(user,userUpdateResponse);
        return userUpdateResponse;
    }
}
