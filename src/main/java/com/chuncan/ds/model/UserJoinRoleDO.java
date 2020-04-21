package com.chuncan.ds.model;

import com.chuncan.ds.model.base.BaseDO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 用户角色关联表
 *
 * @author:YaoShuLi
 * @Date:2020/4/16 0016
 * @Time:15:42
 */
@Data
@ToString
@Table(name = "tb_user_role")
public class UserJoinRoleDO extends BaseDO {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;
}
