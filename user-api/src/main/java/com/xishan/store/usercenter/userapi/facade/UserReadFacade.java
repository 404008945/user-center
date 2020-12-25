package com.xishan.store.usercenter.userapi.facade;

import com.xishan.store.usercenter.userapi.dto.UserDTO;
import com.xishan.store.usercenter.userapi.model.User;

public interface UserReadFacade {
    UserDTO findById(Long Id);

    
}
