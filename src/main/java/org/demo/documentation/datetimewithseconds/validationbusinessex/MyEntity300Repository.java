package org.demo.documentation.datetimewithseconds.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity300Repository extends JpaRepository<MyEntity300, Long>, JpaSpecificationExecutor<MyEntity300> {

}