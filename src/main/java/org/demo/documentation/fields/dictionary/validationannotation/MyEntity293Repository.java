package org.demo.documentation.fields.dictionary.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity293Repository extends JpaRepository<MyEntity293, Long>, JpaSpecificationExecutor<MyEntity293> {

}