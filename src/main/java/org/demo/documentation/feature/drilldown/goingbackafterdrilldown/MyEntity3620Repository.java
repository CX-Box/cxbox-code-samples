package org.demo.documentation.feature.drilldown.goingbackafterdrilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3620Repository extends JpaRepository<MyEntity3620, Long>, JpaSpecificationExecutor<MyEntity3620> {

}
