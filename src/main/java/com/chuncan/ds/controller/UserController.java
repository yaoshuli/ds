package com.chuncan.ds.controller;

import com.chuncan.ds.model.UserDO;
import com.chuncan.ds.service.UserService;
import com.chuncan.ds.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户业务操作控制器
 *
 * @author:YaoShuLi
 * @Date:2020/4/9 0009
 * @Time:15:03
 */
@RestController
@RequestMapping("/user")
@Api(description = "用户业务控制器")
public class UserController {



    /**
     * 用户服务操作接口
     */
    @Autowired
    private UserService userService;

    @ApiOperation("根据用户id查询对应的用户信息")
    @GetMapping("/findUserById")
    public UserDO findUserById(String userId){

        return userService.getUserById(userId);
    }

    @ApiOperation("查询所有用户信息")
    @GetMapping("/findUserAll")
    public List<UserDO> findUserAll(){

        return userService.listUsers();
    }


    @ApiOperation("新增用户接口")
    @PostMapping("/saveUser")
    public Message saveUser(UserDO userDO){
        if(!userService.insertUser(userDO)){
            return new Message("新增失败",500);
        }
        return new Message("新增成功",200);
    }


    @ApiOperation("删除用户接口")
    @DeleteMapping("/removeUser")
    public Message removeUser(String userId){
        if(!userService.deleteUser(userId)){
            return new Message("删除失败",500);
        }
        return new Message("删除成功",200);
    }

    @ApiOperation("修改用户接口")
    @PostMapping("editUser")
    public Message editUser(UserDO userDO){
        if(!userService.updateUser(userDO)){
            return new Message("修改失败",500);
        }
        return new Message("修改成功",200);
    }

}
