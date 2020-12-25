package com.xishan.store.usercenter.userserver.facade;

import com.xishan.store.usercenter.userapi.dto.UserDTO;
import com.xishan.store.usercenter.userapi.facade.UserReadFacade;
import com.xishan.store.usercenter.userapi.model.User;
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
}
