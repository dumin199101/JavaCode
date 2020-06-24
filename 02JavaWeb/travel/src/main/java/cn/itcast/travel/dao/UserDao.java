package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    /**
     * 用户保存
     * @param user
     */
    public void save(User user);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 根据激活码查找用户
     * @param Code
     * @return
     */
    public User findByCode(String Code);

    /**
     * 更新激活用户状态
     * @param user
     */
    void updateStatus(User user);

    /**
     * 用户名密码查找
     * @param user
     */
    User findByUsernameAndPassword(User user);
}
