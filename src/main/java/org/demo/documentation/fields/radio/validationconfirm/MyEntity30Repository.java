package org.demo.documentation.fields.radio.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity30Repository extends JpaRepository<MyEntity30, Long>, JpaSpecificationExecutor<MyEntity30> {

}