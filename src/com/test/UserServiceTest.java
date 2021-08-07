package com.test;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author xjm
 * @create 2020-04-16 20:09
 */
public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void login() {

        System.out.println(userService.login(new User(null,"admin","admin","admin@qq.com")));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("admin111")){
            System.out.println("已存在");
        }else {
            System.out.println("可用");
        }
    }
}