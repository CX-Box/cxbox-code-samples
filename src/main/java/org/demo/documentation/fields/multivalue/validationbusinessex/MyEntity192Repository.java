package org.demo.documentation.fields.multivalue.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity192Repository extends JpaRepository<MyEntity192, Long>, JpaSpecificationExecutor<MyEntity192> {

}