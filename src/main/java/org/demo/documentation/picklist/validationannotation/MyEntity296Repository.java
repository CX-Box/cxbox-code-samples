package org.demo.documentation.picklist.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity296Repository extends JpaRepository<MyEntity296, Long>, JpaSpecificationExecutor<MyEntity296> {

}