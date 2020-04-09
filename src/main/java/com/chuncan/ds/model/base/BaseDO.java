package com.chuncan.ds.model.base;

import com.chuncan.ds.enums.DataStateEnum;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * 公共父类实体对象
 *
 * @author:YaoShuLi
 * @Date:2020/4/9 0009
 * @Time:16:03
 */
@Data
public class BaseDO {

    /**
     * 主键
     */
    @Id
    private String id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @Column(name = "create_user")
    private String createUser;

    /**
     * 修改人
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 数据状态
     */
    @Column(name = "data_state")
    private DataStateEnum dataState;
}
