package com.chuncan.ds.service.impl;

import com.chuncan.ds.mapper.system.PermissionMapper;
import com.chuncan.ds.model.PermissionDO;
import com.chuncan.ds.service.PermissionService;
import com.chuncan.ds.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限服务接口实现类
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:24
 */
@Service
public class PermissionServiceImpl implements PermissionService {


    @Autowired(required = false)
    private PermissionMapper permissionMapper;


    @Override
    public PermissionDO getPermissionById(String permissionId) {
        return permissionMapper.selectByPrimaryKey(permissionId);
    }

    @Override
    public List<PermissionDO> listPermissions() {
        return permissionMapper.selectAll();
    }

    @Override
    public boolean insertPermission(PermissionDO permissionDO) {

        ModelUtils.makeupSaveParameter(permissionDO);

        return permissionMapper.insertSelective(permissionDO)>=0;
    }

    @Override
    public boolean deletePermission(String permissionId) {
        return permissionMapper.deleteByPrimaryKey(permissionId)>=0;
    }

    @Override
    public boolean updatePermission(PermissionDO permissionDO) {

        ModelUtils.makeupUpdateParameter(permissionDO);

        return permissionMapper.updateByPrimaryKeySelective(permissionDO)>=0;
    }
}
