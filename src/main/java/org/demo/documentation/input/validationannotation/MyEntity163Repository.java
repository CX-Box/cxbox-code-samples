package org.demo.documentation.input.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity163Repository extends JpaRepository<MyEntity163, Long>, JpaSpecificationExecutor<MyEntity163> {

}