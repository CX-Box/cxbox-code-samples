package org.demo.documentation.fields.multivalue.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity175Repository extends JpaRepository<MyEntity175, Long>, JpaSpecificationExecutor<MyEntity175> {

}