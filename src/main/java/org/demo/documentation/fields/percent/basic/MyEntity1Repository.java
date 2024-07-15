package org.demo.documentation.fields.percent.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity1Repository extends JpaRepository<MyEntity1, Long>, JpaSpecificationExecutor<MyEntity1> {

}