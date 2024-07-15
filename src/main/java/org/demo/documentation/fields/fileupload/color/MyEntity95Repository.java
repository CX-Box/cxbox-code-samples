package org.demo.documentation.fields.fileupload.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity95Repository extends JpaRepository<MyEntity95, Long>, JpaSpecificationExecutor<MyEntity95> {

}