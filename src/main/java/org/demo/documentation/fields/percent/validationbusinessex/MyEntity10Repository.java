package org.demo.documentation.fields.percent.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity10Repository extends JpaRepository<MyEntity10, Long>, JpaSpecificationExecutor<MyEntity10> {

}