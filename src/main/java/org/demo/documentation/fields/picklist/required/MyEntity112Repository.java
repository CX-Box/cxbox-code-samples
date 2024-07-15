package org.demo.documentation.fields.picklist.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity112Repository extends JpaRepository<MyEntity112, Long>, JpaSpecificationExecutor<MyEntity112> {

}