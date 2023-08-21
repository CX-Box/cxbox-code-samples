package org.demo.documentation.picklist.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity331Repository extends JpaRepository<MyEntity331, Long>, JpaSpecificationExecutor<MyEntity331> {

}