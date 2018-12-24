package com.baizhi.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;

public class MyRealm2 extends AuthenticatingRealm {

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        if("zs".equals(username)){
            return new SimpleAccount("zs","71e412acc9c83e7971338ffe80e7313e",
                    ByteSource.Util.bytes("ABCD")
                    ,UUID.randomUUID().toString());
        }
        return null;
    }
}
