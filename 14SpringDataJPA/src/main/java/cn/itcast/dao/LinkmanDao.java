package cn.itcast.dao;

import cn.itcast.domain.Linkeman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface LinkmanDao extends JpaRepository<Linkeman,Long>, JpaSpecificationExecutor<Linkeman> {
}
