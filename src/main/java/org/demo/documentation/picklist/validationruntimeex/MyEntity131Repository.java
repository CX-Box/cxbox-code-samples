package org.demo.documentation.picklist.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity131Repository extends JpaRepository<MyEntity131, Long>, JpaSpecificationExecutor<MyEntity131> {

}