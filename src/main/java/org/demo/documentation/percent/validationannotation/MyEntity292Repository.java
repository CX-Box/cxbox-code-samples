package org.demo.documentation.percent.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity292Repository extends JpaRepository<MyEntity292, Long>, JpaSpecificationExecutor<MyEntity292> {

}