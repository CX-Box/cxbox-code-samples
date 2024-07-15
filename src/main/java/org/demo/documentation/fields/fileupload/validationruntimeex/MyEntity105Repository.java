package org.demo.documentation.fields.fileupload.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity105Repository extends JpaRepository<MyEntity105, Long>, JpaSpecificationExecutor<MyEntity105> {

}