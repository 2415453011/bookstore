package com.service;

import com.pojo.User;

/**
 * @author xjm
 * @create 2020-04-16 19:59
 */
public interface UserService {
    /**
     *注册用户
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return 如果放回null则登录失败，反之成功
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，反之表示用户名可用
     */
    public boolean existsUsername(String username);
}
