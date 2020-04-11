package com.chuncan.ds.controller;


import com.chuncan.ds.service.UserService;
import com.chuncan.ds.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统操作控制器
 *
 * @author:YaoShuLi
 * @Date:2020/4/10 0010
 * @Time:15:39
 */
@Api(description = "系统操作控制器")
@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录方法")
    @GetMapping("/login")
    public Message login(String userName, String password){

        int code = userService.checkUser(userName,password);
        if(code==200){
            return new Message("登录成功!",200);
        }else if(code == 4006){
            return new Message("用户名不存在!",4006);
        }else if(code == 4007){
            return new Message("用户名或密码不正确!",4007);
        }
        return new Message("系统异常",500);

    }
}
