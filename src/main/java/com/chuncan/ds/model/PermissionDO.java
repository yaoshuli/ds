package com.chuncan.ds.model;

import com.chuncan.ds.model.base.BaseDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * 权限表实体对象
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:16
 */
@Data
@Table(name = "tb_permission")
public class PermissionDO extends BaseDO {

    /**
     * 权限名称
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 权限描述
     */
    @Column(name = "permission_describe")
    private String permissionDescribe;

}
