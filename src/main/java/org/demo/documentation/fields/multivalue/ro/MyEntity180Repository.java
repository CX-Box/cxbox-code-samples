package org.demo.documentation.fields.multivalue.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity180Repository extends JpaRepository<MyEntity180, Long>, JpaSpecificationExecutor<MyEntity180> {

}