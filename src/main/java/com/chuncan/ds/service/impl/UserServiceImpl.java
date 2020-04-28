package com.chuncan.ds.service.impl;

import com.chuncan.ds.mapper.system.UserMapper;
import com.chuncan.ds.model.RoleDO;
import com.chuncan.ds.model.UserDO;
import com.chuncan.ds.model.UserJoinRoleDO;
import com.chuncan.ds.service.RoleService;
import com.chuncan.ds.service.UserJoinRoleService;
import com.chuncan.ds.service.UserService;
import com.chuncan.ds.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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


    @Autowired
    private RoleService roleService;

    @Autowired
    private UserJoinRoleService userJoinRoleService;

    @Override
    public UserDO getUserById(String userId) {
        //1.根据userId查询用户的信息
        UserDO userDO =  userMapper.selectByPrimaryKey(userId);

        //2.如果用户不存在，那就不可能有角色信息
        if(userDO !=null){

            //3.创建用户关联角色的实体对象，用存放查询条件
            UserJoinRoleDO userJoinRoleDO = new UserJoinRoleDO();

            //4.放入用户id
            userJoinRoleDO.setUserId(userId);

            //5.先查询到跟该用户相关联的roleId
            List<UserJoinRoleDO> userJoinRoleList = userJoinRoleService.select(userJoinRoleDO);

            //6.遍历查询到的所有roleId
            for (UserJoinRoleDO joinRoleDO : userJoinRoleList) {

                RoleDO roleDO = roleService.getRoleById(joinRoleDO.getRoleId());
                userDO.getRoles().add(roleDO);
            }
        }

        return  userDO;

    }


    @Override
    public List<UserDO> listUsers(UserDO userDO) {
        return userMapper.selectByUser(userDO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUser(UserDO userDO,String[] roleIds) throws Exception {

        //补齐新增默认字段
        ModelUtils.makeupSaveParameter(userDO);

        for (String roleId : roleIds) {

            boolean result = userJoinRoleService.insertRole(userDO.getId(),roleId);
            if(!result){
               throw new Exception("创建用户和角色关联失败！");
           }
        }

        if(userMapper.insert(userDO) <= 0){
            throw new Exception("创建用户失败！");
        }

        return true;
    }

    @Override
    public boolean updateUser(UserDO userDO) {

        //补齐修改默认字段
        ModelUtils.makeupUpdateParameter(userDO);

        return userMapper.updateByPrimaryKeySelective(userDO)>0?true:false;
    }

    @Override
    @Transactional
    public boolean deleteUser(String userId)  {

        boolean result = true;

        //查询用户和角色的关联表，根据用户id查看是否有该用户关联
        UserJoinRoleDO userJoinRoleDO= new UserJoinRoleDO();
        userJoinRoleDO.setUserId(userId);
        List<UserJoinRoleDO> userJoinRoleServices = userJoinRoleService.select(userJoinRoleDO);

        //如果用户关联数据存在，则先删除关联数据，再删除用户信息
        if(userJoinRoleServices!=null && userJoinRoleServices.size()>1){
            result = userJoinRoleService.deleteByUserId(userId);
        }

        if(result){
            return userMapper.deleteByPrimaryKey(userId)>0?true:false;
        }
        return false;
    }


    @Override
    public int checkUser(String username, String password) {

        UserDO userDO = new UserDO();

        userDO.setUsername(username);

        userDO = userMapper.selectOne(userDO);

        if(userDO!=null){

            if(userDO.getPassword().equals(password)){
                return 200;
            }

            return 4007;
        }
        return 4006;
    }

    @Override
    public UserDO findByUserName(String username) {

        UserDO userDO = new UserDO();

        userDO.setUsername(username);

        userDO = userMapper.selectOne(userDO);

        if(userDO!=null){

            return getUserById(userDO.getId());
        }
        return null;
    }
}
