package org.demo.documentation.feature.drilldown.drilldownfilter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityWithDrilldown4300Repository extends JpaRepository<MyEntityWithDrilldown4300, Long>,
		JpaSpecificationExecutor<MyEntityWithDrilldown4300> {

}
