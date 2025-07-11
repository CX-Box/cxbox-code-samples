package org.demo.documentation.feature.drilldown.drilldownfilter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4300FirstEntityRepository extends JpaRepository<MyEntity4300FirstEntity, Long>,
		JpaSpecificationExecutor<MyEntity4300FirstEntity> {

}
