package com.baizhi.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;

import java.util.UUID;

public class MyRealm extends AuthenticatingRealm {



    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        if("zs".equals(username)){
            return new SimpleAccount("zs","123456", UUID.randomUUID().toString());
        }
               return null;
               }
}
