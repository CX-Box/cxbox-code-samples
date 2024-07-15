package org.demo.documentation.fields.date.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity165Repository extends JpaRepository<MyEntity165, Long>, JpaSpecificationExecutor<MyEntity165> {

}