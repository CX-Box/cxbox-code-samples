package org.demo.documentation.fields.fileupload.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity97Repository extends JpaRepository<MyEntity97, Long>, JpaSpecificationExecutor<MyEntity97> {

}