package com.goosuu.dao;

import com.goosuu.domain.User;


import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    User findByID(Integer id);

    /**
     * 添加用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    int updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(Integer id);

    /**
     * 根据姓名模糊查询
     * @param username
     * @return
     */
    List<User> findUserByName(String username);

    int findTotalUser();
}
