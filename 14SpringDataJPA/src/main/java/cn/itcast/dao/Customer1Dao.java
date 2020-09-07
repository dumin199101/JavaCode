package cn.itcast.dao;

import cn.itcast.domain.Customer1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;



public interface Customer1Dao extends JpaRepository<Customer1,Long>, JpaSpecificationExecutor<Customer1> {
}
