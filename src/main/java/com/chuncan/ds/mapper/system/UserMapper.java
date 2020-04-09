package com.chuncan.ds.mapper.system;

import com.chuncan.ds.mapper.base.BaseMapper;
import com.chuncan.ds.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息数据库操作接口
 *
 * @author:YaoShuLi
 * @Date:2020/4/9 0009
 * @Time:15:32
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
