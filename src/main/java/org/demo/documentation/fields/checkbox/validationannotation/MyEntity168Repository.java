package org.demo.documentation.fields.checkbox.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity168Repository extends JpaRepository<MyEntity168, Long>, JpaSpecificationExecutor<MyEntity168> {

}