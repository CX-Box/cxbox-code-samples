package org.demo.documentation.fields.inlinepicklist.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity281Repository extends JpaRepository<MyEntity281, Long>, JpaSpecificationExecutor<MyEntity281> {

}