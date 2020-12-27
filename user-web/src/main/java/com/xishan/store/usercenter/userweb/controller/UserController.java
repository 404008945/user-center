package com.xishan.store.usercenter.userweb.controller;

import com.alibaba.fastjson.JSON;
import com.xishan.store.usercenter.userapi.dto.UserDTO;
import com.xishan.store.usercenter.userapi.facade.UserReadFacade;
import com.xishan.store.usercenter.userapi.facade.UserWriteFacade;
import com.xishan.store.usercenter.userapi.model.request.UserLoginRequest;
import com.xishan.store.usercenter.userapi.model.request.UserRegisterRequest;
import com.xishan.store.usercenter.userapi.model.request.UserUpdateRequest;
import com.xishan.store.usercenter.userapi.model.response.UserLoginResponse;
import com.xishan.store.usercenter.userapi.model.response.UserRegisterResponse;
import com.xishan.store.usercenter.userapi.model.response.UserUpdateResponse;
import com.xishan.store.usercenter.userweb.vo.LoginResponseVO;
import exception.RestException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Api(value="用户controller",tags={"用户操作接口"})
@RequestMapping("/user")
public class UserController {
    @Reference
    private UserReadFacade userReadFacade;

    @Reference
    private UserWriteFacade userWriteFacade;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    @ResponseBody
    public String index(){
        RpcContext.getContext().setAttachment("user", JSON.toJSONString(new UserDTO()));
        return userReadFacade.findById(1l).toString();
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录接口", httpMethod ="POST" , response = LoginResponseVO.class, notes = "....")
    @ResponseBody
    public LoginResponseVO login(UserLoginRequest  loginRequest, HttpServletRequest httpServletRequest){//用户信息要用aop拦截，登录肯定不用拦截了。
        HttpSession session = httpServletRequest.getSession();


        UserLoginResponse userLoginResponse =  userReadFacade.findByAccount(loginRequest);
        if(userLoginResponse == null){
            throw new RestException("账号活密码不正确");
        }

        if(!passwordEncoder.matches(loginRequest.getPassward(),userLoginResponse.getPassward())) {
         throw new RestException("账号活密码不正确");
        }
        session.setAttribute("user",userLoginResponse);
        LoginResponseVO loginResponseVo = new LoginResponseVO();
        BeanUtils.copyProperties(userLoginResponse,loginResponseVo);
        return loginResponseVo;
    }

    @PostMapping("/register")
    @ApiOperation(value = "用户注册接口", httpMethod ="POST" , response = UserRegisterResponse.class, notes = "....")
    @ResponseBody
    public UserRegisterResponse register(UserRegisterRequest userRegisterRequest){//用户信息要用aop拦截，登录肯定不用拦截了。
        if(userRegisterRequest.getPassward() != null){
            userRegisterRequest.setPassward(passwordEncoder.encode(userRegisterRequest.getPassward()));
        }
        return  userReadFacade.register(userRegisterRequest);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新用户信息接口", httpMethod ="POST" , response = UserUpdateResponse.class, notes = "....")
    @ResponseBody
    public UserUpdateResponse update(UserUpdateRequest userUpdateRequest,HttpServletRequest httpServletRequest) {
        UserUpdateResponse userUpdateResponse =  userWriteFacade.update(userUpdateRequest);
        if(userUpdateResponse == null){
            throw new RestException("更新用户信息失败");
        }
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        BeanUtils.copyProperties(userUpdateResponse,userLoginResponse);
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user",userLoginResponse);
        return userUpdateResponse;
    }

    //单处登录 建立用户与id 与 session的映射



}