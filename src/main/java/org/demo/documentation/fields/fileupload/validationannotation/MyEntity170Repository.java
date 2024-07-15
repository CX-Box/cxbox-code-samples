package org.demo.documentation.fields.fileupload.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity170Repository extends JpaRepository<MyEntity170, Long>, JpaSpecificationExecutor<MyEntity170> {

}