package org.demo.documentation.fields.fileupload.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity100Repository extends JpaRepository<MyEntity100, Long>, JpaSpecificationExecutor<MyEntity100> {

}