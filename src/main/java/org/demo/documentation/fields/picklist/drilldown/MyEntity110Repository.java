package org.demo.documentation.fields.picklist.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity110Repository extends JpaRepository<MyEntity110, Long>, JpaSpecificationExecutor<MyEntity110> {

}