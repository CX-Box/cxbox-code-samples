package org.demo.documentation.multivalue.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity196Repository extends JpaRepository<MyEntity196, Long>, JpaSpecificationExecutor<MyEntity196> {

}