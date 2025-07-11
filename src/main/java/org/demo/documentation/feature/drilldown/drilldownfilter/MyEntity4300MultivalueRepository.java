package org.demo.documentation.feature.drilldown.drilldownfilter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MyEntity4300MultivalueRepository extends JpaRepository<MyEntity4300Multivalue, Long>,
		JpaSpecificationExecutor<MyEntity4300Multivalue> {

}
