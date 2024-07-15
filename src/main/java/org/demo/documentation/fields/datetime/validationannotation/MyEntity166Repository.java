package org.demo.documentation.fields.datetime.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity166Repository extends JpaRepository<MyEntity166, Long>, JpaSpecificationExecutor<MyEntity166> {

}