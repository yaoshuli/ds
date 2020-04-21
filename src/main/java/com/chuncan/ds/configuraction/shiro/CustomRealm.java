package com.chuncan.ds.configuraction.shiro;

import com.chuncan.ds.model.PermissionDO;
import com.chuncan.ds.model.RoleDO;
import com.chuncan.ds.model.UserDO;
import com.chuncan.ds.service.UserService;
import com.chuncan.ds.utils.ErrorCode;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:15:46
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 鉴证 校验我们的登录信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("--------------------账号信息校验开始--------------------");
        //将认证token转换为用户密码token,方便获取用户输入帐名和密码
        UsernamePasswordToken token= ( UsernamePasswordToken) authenticationToken;

        String username =    token.getUsername();
        String password = new String(token.getPassword()) ;


        int code = userService.checkUser(username,password);
        if(code == ErrorCode.LOGIN_NOT_USERNAME){
            throw new AuthenticationException(ErrorCode.LOGIN_NOT_USERNAME_MESSAGE);
        }else if(code == ErrorCode.LOGIN_ERROR_PASSWORD){
            throw new AuthenticationException(ErrorCode.LOGIN_ERROR_PASSWORD_MESSAGE);
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(),authenticationToken.getCredentials(),getName());
    }


    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {



        //定义权限信息类，用于存储权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //1.根据用户名来获取这个用户的权限信息
        UserDO userDO= userService.findByUserName(principalCollection.getPrimaryPrincipal().toString());

        if(userDO!=null){
            for (RoleDO role : userDO.getRoles()) {
                info.addRole(role.getRoleName());
                for (PermissionDO permission : role.getPermissions()) {
                    info.addStringPermission(permission.getPermissionName());

                    System.out.println(permission.getPermissionName());
                }
            }
        }

        return info;
    }

}
