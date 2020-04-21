package com.chuncan.ds.service.impl;

import com.chuncan.ds.mapper.system.RoleMapper;
import com.chuncan.ds.model.PermissionDO;
import com.chuncan.ds.model.RoleDO;
import com.chuncan.ds.model.RoleJoinPermissionDO;
import com.chuncan.ds.service.PermissionService;
import com.chuncan.ds.service.RoleJoinPermissionService;
import com.chuncan.ds.service.RoleService;
import com.chuncan.ds.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 角色服务接口实现类
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:24
 */
@Service
public class RoleServiceImpl implements RoleService {


    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Autowired
    private RoleJoinPermissionService roleJoinPermissionService;

    @Autowired
    private PermissionService permissionService;


    @Override
    public RoleDO getRoleById(String roleId) {

        //1.根据roleId查询角色的信息
        RoleDO roleDO = roleMapper.selectByPrimaryKey(roleId);

        //2.如果角色不存在，那就不可能有权限
        if(roleDO!=null){

            //3.创建角色关联权限的实体对象，用存放查询条件
            RoleJoinPermissionDO rjpd  = new RoleJoinPermissionDO();

            //4.放入角色id
            rjpd.setRoleId(roleId);

            //5.先查询到跟该角色相关联的权限id
            List<RoleJoinPermissionDO> rjpds = roleJoinPermissionService.select(rjpd);

            //6.根据查询到的权限id遍历查询出所有权限的详细信息
            for (RoleJoinPermissionDO roleJoinP : rjpds) {
                PermissionDO permissionDO = permissionService.getPermissionById(roleJoinP.getPermissionId());

                roleDO.getPermissions().add(permissionDO);
            }
        }


        return roleDO;
    }

    @Override
    public List<RoleDO> listRoles() {
        return roleMapper.selectAll();
    }

    @Override
    public boolean insertRole(RoleDO roleDO) {

        ModelUtils.makeupSaveParameter(roleDO);

        return roleMapper.insertSelective(roleDO)>=0;
    }

    @Override
    public boolean deleteRole(String roleId) {
        return roleMapper.deleteByPrimaryKey(roleId)>=0;
    }

    @Override
    public boolean updateRole(RoleDO roleDO) {

        ModelUtils.makeupUpdateParameter(roleDO);

        return roleMapper.updateByPrimaryKeySelective(roleDO)>=0;
    }
}
