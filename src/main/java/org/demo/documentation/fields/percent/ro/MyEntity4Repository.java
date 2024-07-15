package org.demo.documentation.fields.percent.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4Repository extends JpaRepository<MyEntity4, Long>, JpaSpecificationExecutor<MyEntity4> {

}