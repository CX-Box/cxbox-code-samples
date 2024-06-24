package org.demo.documentation.feature.drilldown.drilldowntypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3613Repository extends JpaRepository<MyEntity3613, Long>, JpaSpecificationExecutor<MyEntity3613> {

}
