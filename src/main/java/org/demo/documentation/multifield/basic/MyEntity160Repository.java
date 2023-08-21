package org.demo.documentation.multifield.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity160Repository extends JpaRepository<MyEntity160, Long>, JpaSpecificationExecutor<MyEntity160> {

}