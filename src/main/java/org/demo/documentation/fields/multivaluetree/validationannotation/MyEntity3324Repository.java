package org.demo.documentation.fields.multivaluetree.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3324Repository extends JpaRepository<MyEntity3324, Long>, JpaSpecificationExecutor<MyEntity3324> {

}