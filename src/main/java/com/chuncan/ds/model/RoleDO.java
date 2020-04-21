package com.chuncan.ds.model;

import com.chuncan.ds.model.base.BaseDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色表实体对象
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:17:16
 */
@Data
@Table(name = "tb_role")
public class RoleDO extends BaseDO {

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "role_describe")
    private String roleDescribe;


    private List<PermissionDO> permissions = new ArrayList<>();

}
