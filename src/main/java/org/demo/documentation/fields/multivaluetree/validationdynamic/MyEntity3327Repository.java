package org.demo.documentation.fields.multivaluetree.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3327Repository extends JpaRepository<MyEntity3327, Long>, JpaSpecificationExecutor<MyEntity3327> {

}