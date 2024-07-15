package org.demo.documentation.fields.checkbox.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity82Repository extends JpaRepository<MyEntity82, Long>, JpaSpecificationExecutor<MyEntity82> {

}