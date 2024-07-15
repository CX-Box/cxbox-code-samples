package org.demo.documentation.fields.picklist.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity118Repository extends JpaRepository<MyEntity118, Long>, JpaSpecificationExecutor<MyEntity118> {

}