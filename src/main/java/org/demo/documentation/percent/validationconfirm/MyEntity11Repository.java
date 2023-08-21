package org.demo.documentation.percent.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity11Repository extends JpaRepository<MyEntity11, Long>, JpaSpecificationExecutor<MyEntity11> {

}