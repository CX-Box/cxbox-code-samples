package org.demo.documentation.multivalue.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity198Repository extends JpaRepository<MyEntity198, Long>, JpaSpecificationExecutor<MyEntity198> {

}