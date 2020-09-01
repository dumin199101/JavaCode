package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.function.Consumer;

public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {
    @Query(value = "from Customer")
    List<Customer> findAllCustomer();

    @Query(value = "update Customer set custName = ?1 where custId = ?2")
    @Modifying
    void updateCustomer(String custName,Long custId);

    @Query(value = "select * from cst_customer",nativeQuery = true)
    List<Object[]> findSql();

    public List<Customer> findByCustAddress(String custAddress);

}
