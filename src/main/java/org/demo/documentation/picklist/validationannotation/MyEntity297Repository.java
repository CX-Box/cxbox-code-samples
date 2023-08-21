package org.demo.documentation.picklist.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity297Repository extends JpaRepository<MyEntity297, Long>, JpaSpecificationExecutor<MyEntity296> {

}