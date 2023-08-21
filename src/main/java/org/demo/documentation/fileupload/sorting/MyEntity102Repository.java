package org.demo.documentation.fileupload.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity102Repository extends JpaRepository<MyEntity102, Long>, JpaSpecificationExecutor<MyEntity102> {

}