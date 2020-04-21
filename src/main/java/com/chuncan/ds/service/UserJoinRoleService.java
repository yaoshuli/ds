package com.chuncan.ds.service;

import com.chuncan.ds.model.UserDO;
import com.chuncan.ds.model.UserJoinRoleDO;

import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:48
 */
public interface UserJoinRoleService {

    boolean insertRole(String userId, String roleId);


    UserDO selectUserJoin(String userId);


    boolean deleteByUserId(String userId);

    List<UserJoinRoleDO> select(UserJoinRoleDO userJoinRoleDO);
}
