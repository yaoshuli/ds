package com.chuncan.ds.controller;

import com.chuncan.ds.model.RoleDO;
import com.chuncan.ds.service.RoleService;
import com.chuncan.ds.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色信息控制器
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:14
 */
@RestController
@RequestMapping("/role")
@Api(description = "角色业务控制器")
public class RoleController {

    /**
     * 角色服务操作接口
     */
    @Autowired
    private RoleService roleService;

    @ApiOperation("根据角色id查询对应的角色信息")
    @GetMapping("/findRoleById")
    public RoleDO findRoleById(String roleId){

        return roleService.getRoleById(roleId);
    }

    @ApiOperation("查询所有角色信息")
    @GetMapping("/findRoleAll")
    public List<RoleDO> findRoleAll(){

        return roleService.listRoles();
    }


    @ApiOperation("新增角色接口")
    @PostMapping("/saveRole")
    public Message saveRole(RoleDO roleDO){
        if(!roleService.insertRole(roleDO)){
            return new Message("新增失败",500);
        }
        return new Message("新增成功",200);
    }


    @ApiOperation("删除角色接口")
    @DeleteMapping("/removeRole")
    public Message removeRole(String roleId){
        if(!roleService.deleteRole(roleId)){
            return new Message("删除失败",500);
        }
        return new Message("删除成功",200);
    }

    @ApiOperation("修改角色接口")
    @PostMapping("editRole")
    public Message editRole(RoleDO roleDO){
        if(!roleService.updateRole(roleDO)){
            return new Message("修改失败",500);
        }
        return new Message("修改成功",200);
    }

}
