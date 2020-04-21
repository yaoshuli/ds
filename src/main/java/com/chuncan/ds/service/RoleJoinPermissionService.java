package com.chuncan.ds.service;

import com.chuncan.ds.model.RoleJoinPermissionDO;

import java.util.List;

/**
 * 角色关联权限服务接口
 *
 * @author:YaoShuLi
 * @Date:2020/4/16 0016
 * @Time:16:20
 */
public interface RoleJoinPermissionService {

    List<RoleJoinPermissionDO> select(RoleJoinPermissionDO rjpd);
}
