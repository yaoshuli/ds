package com.chuncan.ds.model;

import com.chuncan.ds.model.base.BaseDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 角色权限关联表实体类
 *
 * @author:YaoShuLi
 * @Date:2020/4/16 0016
 * @Time:16:12
 */
@Data
@Table(name = "tb_role_permission")
public class RoleJoinPermissionDO extends BaseDO {

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "permission_id")
    private String permissionId;
}
