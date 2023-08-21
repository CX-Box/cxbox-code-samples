package org.demo.documentation.percent.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity328Repository extends JpaRepository<MyEntity328, Long>, JpaSpecificationExecutor<MyEntity328> {

}