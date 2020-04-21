package com.chuncan.ds.service;

import com.chuncan.ds.model.RoleDO;

import java.util.List;

/**
 * 角色服务接口
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:22
 */
public interface RoleService {

    RoleDO getRoleById(String roleId);

    List<RoleDO> listRoles();

    boolean insertRole(RoleDO roleDO);

    boolean deleteRole(String roleId);

    boolean updateRole(RoleDO roleDO);
}
