package org.demo.documentation.fields.time.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4102Repository extends JpaRepository<MyEntity4102, Long>, JpaSpecificationExecutor<MyEntity4102> {

}