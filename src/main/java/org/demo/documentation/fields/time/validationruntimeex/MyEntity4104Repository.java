package org.demo.documentation.fields.time.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4104Repository extends JpaRepository<MyEntity4104, Long>, JpaSpecificationExecutor<MyEntity4104> {

}