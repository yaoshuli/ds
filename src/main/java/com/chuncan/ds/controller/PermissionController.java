package com.chuncan.ds.controller;

import com.chuncan.ds.model.PermissionDO;
import com.chuncan.ds.service.PermissionService;
import com.chuncan.ds.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限信息控制器
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:14
 */
@RestController
@RequestMapping("/permission")
@Api(description = "权限业务控制器")
public class PermissionController {

    /**
     * 权限服务操作接口
     */
    @Autowired
    private PermissionService permissionService;

    @ApiOperation("根据权限id查询对应的权限信息")
    @GetMapping("/findPermissionById")
    public PermissionDO findPermissionById(String permissionId){

        return permissionService.getPermissionById(permissionId);
    }

    @ApiOperation("查询所有权限信息")
    @GetMapping("/findPermissionAll")
    public List<PermissionDO> findPermissionAll(){

        return permissionService.listPermissions();
    }


    @ApiOperation("新增权限接口")
    @PostMapping("/savePermission")
    public Message savePermission(PermissionDO permissionDO){
        if(!permissionService.insertPermission(permissionDO)){
            return new Message("新增失败",500);
        }
        return new Message("新增成功",200);
    }


    @ApiOperation("删除权限接口")
    @DeleteMapping("/removePermission")
    public Message removePermission(String permissionId){
        if(!permissionService.deletePermission(permissionId)){
            return new Message("删除失败",500);
        }
        return new Message("删除成功",200);
    }

    @ApiOperation("修改权限接口")
    @PostMapping("editPermission")
    public Message editPermission(PermissionDO permissionDO){
        if(!permissionService.updatePermission(permissionDO)){
            return new Message("修改失败",500);
        }
        return new Message("修改成功",200);
    }

}
