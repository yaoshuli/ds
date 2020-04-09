package com.chuncan.ds.utils;

import com.chuncan.ds.enums.DataStateEnum;
import com.chuncan.ds.model.base.BaseDO;
import tk.mybatis.mapper.util.StringUtil;

import java.time.LocalDateTime;

/**
 * 保存工具类
 *
 * @author:YaoShuLi
 * @Date:2020/4/9 0009
 * @Time:15:58
 */
public class ModelUtils {

    /**
     * 补齐新增时共有必填字段
     * @param baseDO 共有字段父类
     */
    public static void makeupSaveParameter(BaseDO baseDO){

        //判断id是否为空，为空则自动生成一个id
        if(StringUtil.isEmpty(baseDO.getId())){
            baseDO.setId(IdUtils.getRandomIdByUUID());
        }

        //判断创建用户是为空，为空则设置为1 及admin账号
        if(StringUtil.isEmpty(baseDO.getCreateUser())){
            baseDO.setCreateUser("1");
        }

        //设置创建时间
        baseDO.setCreateTime(LocalDateTime.now());

        //设置默认数据状态 默认为可用
        baseDO.setDataState(DataStateEnum.AVAILABLE);
    }


    /**
     * 补齐修改时的共有必填字段
     * @param baseDO 共有字段父类
     */
    public static void makeupUpdateParameter(BaseDO baseDO){

        //判断创建用户是为空，为空则设置为1 及admin账号
        if(StringUtil.isEmpty(baseDO.getUpdateUser())){
            baseDO.setUpdateUser("1");
        }

        //设置创建时间
        baseDO.setUpdateTime(LocalDateTime.now());
    }
}
