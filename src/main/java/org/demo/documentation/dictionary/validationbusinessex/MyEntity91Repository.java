package org.demo.documentation.dictionary.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity91Repository extends JpaRepository<MyEntity91, Long>, JpaSpecificationExecutor<MyEntity91> {

}