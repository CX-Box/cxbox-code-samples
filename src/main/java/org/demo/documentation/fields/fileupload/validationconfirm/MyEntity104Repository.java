package org.demo.documentation.fields.fileupload.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity104Repository extends JpaRepository<MyEntity104, Long>, JpaSpecificationExecutor<MyEntity104> {

}