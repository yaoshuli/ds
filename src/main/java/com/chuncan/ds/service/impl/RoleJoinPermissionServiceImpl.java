package com.chuncan.ds.service.impl;

import com.chuncan.ds.mapper.system.RoleJoinPermissionMapper;
import com.chuncan.ds.model.RoleJoinPermissionDO;
import com.chuncan.ds.service.RoleJoinPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色关联权限服务实现类
 *
 * @author:YaoShuLi
 * @Date:2020/4/16 0016
 * @Time:16:21
 */
@Service
public class RoleJoinPermissionServiceImpl implements RoleJoinPermissionService {

    @Autowired(required = false)
    private RoleJoinPermissionMapper roleJoinPermissionMapper;

    @Override
    public List<RoleJoinPermissionDO> select(RoleJoinPermissionDO rjpd) {

        return roleJoinPermissionMapper.select(rjpd);
    }
}
