package org.demo.documentation.fields.time.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4103Repository extends JpaRepository<MyEntity4103, Long>, JpaSpecificationExecutor<MyEntity4103> {

}