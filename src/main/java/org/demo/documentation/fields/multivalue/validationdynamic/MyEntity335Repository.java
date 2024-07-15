package org.demo.documentation.fields.multivalue.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity335Repository extends JpaRepository<MyEntity335, Long>, JpaSpecificationExecutor<MyEntity335> {

}