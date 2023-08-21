package org.demo.documentation.fileupload.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity94Repository extends JpaRepository<MyEntity94, Long>, JpaSpecificationExecutor<MyEntity94> {

}