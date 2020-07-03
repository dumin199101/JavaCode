package com.goosuu.dao;

import com.goosuu.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IAccountDao {
    @Select("select * from account where uid = #{uid}")
    List<Account> findById(Integer uid);
}
