package org.demo.documentation.multivalue.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity189Repository extends JpaRepository<MyEntity189, Long>, JpaSpecificationExecutor<MyEntity189> {

}