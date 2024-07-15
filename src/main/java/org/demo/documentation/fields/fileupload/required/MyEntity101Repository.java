package org.demo.documentation.fields.fileupload.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity101Repository extends JpaRepository<MyEntity101, Long>, JpaSpecificationExecutor<MyEntity101> {

}