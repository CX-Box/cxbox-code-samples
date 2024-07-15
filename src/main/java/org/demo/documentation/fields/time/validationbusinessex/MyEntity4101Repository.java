package org.demo.documentation.fields.time.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4101Repository extends JpaRepository<MyEntity4101, Long>, JpaSpecificationExecutor<MyEntity4101> {

}