package com.dao;

import com.pojo.User;

/**
 *
 * @author xjm
 * @create 2020-04-16 19:08
 *
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 如果用户名返回null，说明没有这个用户
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户信息
     * @param username
     * @param password
     * @return 如果用户名返回null，说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     * @param user 用户名
     * @return 返回-1表示操作失败，其他是影响行数
     */
    public int saveUser(User user);
}
