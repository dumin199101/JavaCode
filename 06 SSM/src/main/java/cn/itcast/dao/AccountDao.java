package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao{
    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 增加账户
     */
    @Insert("insert into account(name,money) values(#{name},#{money})")
    void saveAccount(Account account);

}
