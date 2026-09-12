package org.demo.documentation.fields.multivaluetree.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3322Repository extends JpaRepository<MyEntity3322, Long>, JpaSpecificationExecutor<MyEntity3322> {

}