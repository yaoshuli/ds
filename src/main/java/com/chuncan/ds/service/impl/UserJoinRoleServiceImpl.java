package com.chuncan.ds.service.impl;

import com.chuncan.ds.mapper.system.UserJoinRoleMapper;
import com.chuncan.ds.model.RoleDO;
import com.chuncan.ds.model.UserDO;
import com.chuncan.ds.model.UserJoinRoleDO;
import com.chuncan.ds.service.RoleService;
import com.chuncan.ds.service.UserJoinRoleService;
import com.chuncan.ds.service.UserService;
import com.chuncan.ds.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:49
 */
@Service
public class UserJoinRoleServiceImpl implements UserJoinRoleService {

    @Autowired(required = false)
    private UserJoinRoleMapper userJoinRoleMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Override
    public boolean insertRole(String userId, String roleId) {
        UserJoinRoleDO userJoinRoleDO = new UserJoinRoleDO();
        userJoinRoleDO.setUserId(userId);
        userJoinRoleDO.setRoleId(roleId);

        ModelUtils.makeupSaveParameter(userJoinRoleDO);

        int rt = userJoinRoleMapper.insert(userJoinRoleDO);

        return rt >0;
    }

    @Override

    public UserDO selectUserJoin(String userId) {



        return null;
    }

    @Override
    public boolean deleteByUserId(String userId) {
        return userJoinRoleMapper.deleteByUserId(userId)>0;
    }

    @Override
    public List<UserJoinRoleDO> select(UserJoinRoleDO userJoinRoleDO) {
        return userJoinRoleMapper.select(userJoinRoleDO);
    }

}
