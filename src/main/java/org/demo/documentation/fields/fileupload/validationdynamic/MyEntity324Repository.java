package org.demo.documentation.fields.fileupload.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity324Repository extends JpaRepository<MyEntity324, Long>, JpaSpecificationExecutor<MyEntity324> {

}