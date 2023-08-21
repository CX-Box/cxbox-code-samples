package org.demo.documentation.number.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberDrillDownEntityRepository extends JpaRepository<NumberDrillDownEntity, Long>,
		JpaSpecificationExecutor<NumberDrillDownEntity> {

}