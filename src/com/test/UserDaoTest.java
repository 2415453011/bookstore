package com.test;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import org.junit.Test;

/**
 * @author xjm
 * @create 2020-04-16 19:33
 */
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin1") == null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin1") == null){
            System.out.println("用户名或密码错误，登陆失败");
        }else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveUser(){
        System.out.println(userDao.saveUser(new User(null,"login","pwd","abc@qq.com")));
    }
}