package com.chuncan.ds.configuraction.shiro;

//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro 框架集成配置
 *
 * @author:YaoShuLi
 * @Date:2020/4/15 0015
 * @Time:15:39
 */
@Configuration
public class ShiroConfiguration {


    /**
     * 创建自定义realm对象
     * @return
     */
    @Bean
    public CustomRealm customRealm(){
        return  new CustomRealm();
    }


    /**
     * 自定义安全管理器
     * @return
     */
    @Bean
    public SecurityManager securityManager(){

        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(customRealm());

        return securityManager;
    }



    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){

        //定义shiro拦截器工厂对象 用于设置shiro
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置shiro安全管理器，其中配置了自定义的Realm
        shiroFilterFactoryBean.setSecurityManager(securityManager);




        /**
         * 定义存储资源过滤Map,用于设置不同资源下过滤器选择
         *  authc:这个过滤器用于判断当前用户是否已经完成认证,已经认证就放行，如果当前用户没有认证，跳转到登录页面
         *  anon:允许在不登录情况下匿名访问
         *  roles[xxx]: 必须有xxx角色才可以访问
         *
         */
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();


        //开放登录界面
        filterChainDefinitionMap.put("/system/*", "anon");


        //放行swagger2
        filterChainDefinitionMap.put("/swagger-ui.html","anon");
        filterChainDefinitionMap.put("/swagger/**","anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/swagger-resources/**","anon");
        filterChainDefinitionMap.put("/v2/**","anon");
        filterChainDefinitionMap.put("/static/**", "anon");


        //登出请求
        filterChainDefinitionMap.put("/logout", "logout");

        //其余接口一律拦截
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        filterChainDefinitionMap.put("/**", "anon");

        //将设置好的过滤器Map赋值到shiro中
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);


        return shiroFilterFactoryBean;
    }


    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions)
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * 如果不配置下面两个方法，则shiro注解会失效
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;

    }
}
