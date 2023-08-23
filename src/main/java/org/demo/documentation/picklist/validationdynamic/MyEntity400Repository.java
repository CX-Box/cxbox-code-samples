package org.demo.documentation.picklist.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity400Repository extends JpaRepository<MyEntity400, Long>, JpaSpecificationExecutor<MyEntity400> {

}