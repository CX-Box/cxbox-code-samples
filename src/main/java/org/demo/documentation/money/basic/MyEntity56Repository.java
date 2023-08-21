package org.demo.documentation.money.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity56Repository extends JpaRepository<MyEntity56, Long>, JpaSpecificationExecutor<MyEntity56> {

}