package org.demo.documentation.fields.picklist.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity109Repository extends JpaRepository<MyEntity109, Long>, JpaSpecificationExecutor<MyEntity109> {

}