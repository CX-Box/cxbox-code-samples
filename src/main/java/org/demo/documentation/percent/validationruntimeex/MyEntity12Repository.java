package org.demo.documentation.percent.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity12Repository extends JpaRepository<MyEntity12, Long>, JpaSpecificationExecutor<MyEntity12> {

}