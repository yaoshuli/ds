package com.chuncan.ds.mapper.system;

import com.chuncan.ds.mapper.base.BaseMapper;
import com.chuncan.ds.model.UserJoinRoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 自定义
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:50
 */
@Mapper
public interface UserJoinRoleMapper extends BaseMapper<UserJoinRoleDO> {

    int userJoinRole(String userId, String roleId);

//    List<Map<String, Object>> selectJoinByUserId(String userId);

    int deleteByUserId(String userId);
}
