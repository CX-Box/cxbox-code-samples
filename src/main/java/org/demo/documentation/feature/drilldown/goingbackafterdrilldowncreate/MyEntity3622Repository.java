package org.demo.documentation.feature.drilldown.goingbackafterdrilldowncreate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3622Repository extends JpaRepository<MyEntity3622, Long>, JpaSpecificationExecutor<MyEntity3622> {

}
