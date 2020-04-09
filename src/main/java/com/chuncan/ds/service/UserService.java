package com.chuncan.ds.service;

import com.chuncan.ds.model.UserDO;

import java.util.List;

/**
 * 用户服务操作接口
 *
 * @author:YaoShuLi
 * @Date:2020/4/9 0009
 * @Time:15:20
 */
public interface UserService {

    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    UserDO getUserById(String userId);

    /**
     * 获取所有用户信息
     * @return
     */
    List<UserDO> listUsers();

    /**
     * 新增用户信息
     * @param userDO
     * @return
     */
    boolean insertUser(UserDO userDO);


    /**
     * 修改用户信息
     * @param userDO
     * @return
     */
    boolean updateUser(UserDO userDO);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    boolean deleteUser(String userId);

}
