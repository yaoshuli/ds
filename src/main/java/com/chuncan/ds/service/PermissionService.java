package com.chuncan.ds.service;

import com.chuncan.ds.model.PermissionDO;

import java.util.List;

/**
 * 权限服务接口
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:30
 */
public interface PermissionService {
    PermissionDO getPermissionById(String permissionId);

    List<PermissionDO> listPermissions();

    boolean insertPermission(PermissionDO permissionDO);

    boolean deletePermission(String permissionId);

    boolean updatePermission(PermissionDO permissionDO);
}
