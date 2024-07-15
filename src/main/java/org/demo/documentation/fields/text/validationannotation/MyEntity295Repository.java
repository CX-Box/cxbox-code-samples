package org.demo.documentation.fields.text.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity295Repository extends JpaRepository<MyEntity295, Long>, JpaSpecificationExecutor<MyEntity295> {

}