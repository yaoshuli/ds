package com.chuncan.ds.service.impl;

import com.chuncan.ds.mapper.system.UserMapper;
import com.chuncan.ds.model.UserDO;
import com.chuncan.ds.service.UserService;
import com.chuncan.ds.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 用户服务实现类
 *
 * @author:YaoShuLi
 * @Date:2020/4/9 0009
 * @Time:15:26
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 用户表数据库操作接口
     */
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public UserDO getUserById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }


    @Override
    public List<UserDO> listUsers() {
        return userMapper.selectAll();

    }

    @Override
    public boolean insertUser(UserDO userDO) {

        //补齐新增默认字段
        ModelUtils.makeupSaveParameter(userDO);

        return userMapper.insert(userDO) > 0 ? true : false;
    }

    @Override
    public boolean updateUser(UserDO userDO) {

        //补齐修改默认字段
        ModelUtils.makeupUpdateParameter(userDO);

        return userMapper.updateByPrimaryKeySelective(userDO)>0?true:false;
    }

    @Override
    public boolean deleteUser(String userId) {
        return userMapper.deleteByPrimaryKey(userId)>0?true:false;
    }
}
