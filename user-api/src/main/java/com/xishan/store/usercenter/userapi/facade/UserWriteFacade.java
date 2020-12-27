package com.xishan.store.usercenter.userapi.facade;

import com.xishan.store.usercenter.userapi.model.request.UserUpdateRequest;
import com.xishan.store.usercenter.userapi.model.response.UserUpdateResponse;

public interface UserWriteFacade {


     UserUpdateResponse update(UserUpdateRequest userUpdateRequest);

}
