package org.demo.documentation.feature.drilldown.drilldownfilter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4300SecondEntityRepository extends JpaRepository<MyEntity4300SecondEntity, Long>,
		JpaSpecificationExecutor<MyEntity4300SecondEntityRepository> {

}
