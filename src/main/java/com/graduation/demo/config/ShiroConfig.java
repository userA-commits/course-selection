package com.graduation.demo.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.graduation.demo.shiro.AdminRealm;
import com.graduation.demo.shiro.StudentRealm;
import com.graduation.demo.shiro.TeacherRealm;
import com.graduation.demo.shiro.UserModularRealmAuthenticator;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    @Bean
    public AdminRealm adminRealm(){
        return new AdminRealm();
    }

    @Bean
    public TeacherRealm teacherRealm(){
        return new TeacherRealm();
    }

    @Bean
    public StudentRealm studentRealm(){
        return new StudentRealm();
    }

    //权限管理，主要功能是链接Realm和用户
    @Bean
    public DefaultSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //添加多个Realm
        List<Realm> realms = new ArrayList<>();
        realms.add(adminRealm());
        realms.add(teacherRealm());
        realms.add(studentRealm());
        //放入容器
        securityManager.setRealms(realms);
        return securityManager;
    }

    //注入自己重写的ModularRealmAuthenticator
    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator(){
        UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        return modularRealmAuthenticator;
    }

    //Filter工厂，设置对应的过滤条件和跳转条件
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> map = new HashMap<>();
//        //登出
//        map.put("/logout", "logout");
//        //对所有用户认证
//        map.put("/**", "authc");
//        //登录
//        shiroFilterFactoryBean.setLoginUrl("/login/**");
//        //对swagger开放权限
//        map.put("/swagger_ui.html", "anon");
//        map.put("/webjars/**", "anon");
//        map.put("/v2/**", "anon");
//        map.put("/swagger-resources/**", "anon");
//        map.put("/doc.html/**", "anon");
//        //首页
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        //错误页面，认证不通过跳转
//        shiroFilterFactoryBean.setUnauthorizedUrl("/error");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }


    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    //配置整合shiro与thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }
}
