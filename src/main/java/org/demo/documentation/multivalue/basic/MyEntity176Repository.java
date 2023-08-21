package org.demo.documentation.multivalue.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity176Repository extends JpaRepository<MyEntity176, Long>, JpaSpecificationExecutor<MyEntity176> {

}