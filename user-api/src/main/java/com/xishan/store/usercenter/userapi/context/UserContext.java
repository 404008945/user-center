package com.xishan.store.usercenter.userapi.context;

import com.xishan.store.usercenter.userapi.dto.UserDTO;

/**
 * web和server通用上下文
 */
public class UserContext {
    private static ThreadLocal<UserDTO> userThreadLocal = new ThreadLocal<>();

    public static void putCurrentUser(UserDTO userDTO){
        userThreadLocal.set(userDTO);
    }

    public static UserDTO getCurrentUser(){
        return userThreadLocal.get();
    }

    public static void clearCurrentUser(){
        userThreadLocal.remove();
    }

}
