package org.demo.documentation.time.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4100Repository extends JpaRepository<MyEntity4100, Long>, JpaSpecificationExecutor<MyEntity4100> {

}