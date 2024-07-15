package org.demo.documentation.fields.multivalue.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity199Repository extends JpaRepository<MyEntity199, Long>, JpaSpecificationExecutor<MyEntity199> {

}