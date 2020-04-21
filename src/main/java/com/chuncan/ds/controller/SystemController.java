package com.chuncan.ds.controller;


import com.chuncan.ds.service.UserService;
import com.chuncan.ds.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.util.StringUtil;

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



    @ApiOperation("shiro的登录方法")
    @GetMapping("/login")
    public Message login(String userName, String password){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,password);
        try {
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e){
          return new Message(e.getMessage(),500);
        }

        return new Message("成功",200);
    }


    @ApiOperation("测试shiro的用户登录")
    @GetMapping("/checkLoginUser")
    public String checkLoginUser(){
       Subject subject= SecurityUtils.getSubject();

       if(subject !=null && subject.getPrincipal()!=null){
           return subject.getPrincipal().toString();
       }

       return "还没有用户在登陆";
    }


}
