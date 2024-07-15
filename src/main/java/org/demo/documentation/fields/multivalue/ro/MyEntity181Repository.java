package org.demo.documentation.fields.multivalue.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity181Repository extends JpaRepository<MyEntity181, Long>, JpaSpecificationExecutor<MyEntity181> {

}