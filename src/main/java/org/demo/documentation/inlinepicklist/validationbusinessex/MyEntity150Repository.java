package org.demo.documentation.inlinepicklist.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity150Repository extends JpaRepository<MyEntity150, Long>, JpaSpecificationExecutor<MyEntity150> {

}