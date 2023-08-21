package org.demo.documentation.money.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity61Repository extends JpaRepository<MyEntity61, Long>, JpaSpecificationExecutor<MyEntity61> {

}