package com.baizhi.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    @RequestMapping("/login")
    public String login(String username, String password) {
        try {
            //1. 从安全工具类中获取主体对象
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("username:"+subject.getPrincipal());
        } catch (UnknownAccountException uae) {
            return "redirect:/login.jsp?username=error";
        } catch (IncorrectCredentialsException ice) {
            return "redirect:/login.jsp?password=error";
        } catch (AuthenticationException e) {
            return "redirect:/login.jsp";
        }
        return "redirect:/main.jsp";
    }
}