package org.demo.documentation.fields.date.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface dateDrillDownEntityRepository extends JpaRepository<dateDrillDownEntity, Long>,
		JpaSpecificationExecutor<dateDrillDownEntity> {

}