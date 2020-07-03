package com.goosuu.dao;

import com.goosuu.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
        @Result(id = true,property = "userId",column = "id"),
        @Result(property = "userName",column = "username"),
        @Result(property = "userBirthday",column = "birthday"),
        @Result(property = "userSex",column = "sex"),
        @Result(property = "userAddress",column = "address"),
        @Result(property = "accounts",column = "id",many = @Many(select = "com.goosuu.dao.IAccountDao.findById",
                fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{uid}")
    @ResultMap("userMap")
    User findByID(Integer id);

    /**
     * 添加用户
     * @param user
     */
    @Insert("insert into user(username,sex,birthday,address) values(#{userName},#{userSex},#{userBirthday}," +
            "#{userAddress})")
    @SelectKey(keyProperty = "userId",keyColumn = "id",before = false,resultType = Integer.class,statement = "select " +
            "last_insert_id()")
    int saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username = #{userName},sex=#{userSex},birthday=#{userBirthday},address=#{userAddress} " +
            "where id = #{userId}")
    int updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Delete("delete from user where id = #{uid}")
    int deleteUser(Integer id);

    /**
     * 根据姓名模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    @ResultMap("userMap")
    List<User> findUserByName(String username);

    /**
     * 查询数量
     * @return
     */
    @Select("select count(*) from user")
    int findTotalUser();
}
