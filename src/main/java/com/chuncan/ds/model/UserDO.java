package com.chuncan.ds.model;


import com.chuncan.ds.enums.UserSexEnum;
import com.chuncan.ds.model.base.BaseDO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户表实体对象
 *
 * @author:YaoShuLi
 * @Date:2020/4/9 0009
 * @Time:14:52
 */
@Data
@Table(name = "tb_user")
public class UserDO extends BaseDO {

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 用户密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 用户手机号
     */
    @Column(name = "phone")
    private String phone;


    /**
     * 用户邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 用户生日
     */
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    /**
     * 用户性别
     */
    @Column(name = "sex")
    private UserSexEnum sex;



    private List<RoleDO> roles = new ArrayList<>();





}
