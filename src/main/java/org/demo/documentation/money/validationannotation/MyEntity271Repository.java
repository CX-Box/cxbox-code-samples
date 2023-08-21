package org.demo.documentation.money.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity271Repository extends JpaRepository<MyEntity271, Long>, JpaSpecificationExecutor<MyEntity271> {

}