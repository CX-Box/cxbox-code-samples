package org.demo.documentation.fields.datetimewithseconds.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsDrillDownEntityRepository extends
		JpaRepository<DateTimeWithSecondsDrillDownEntity, Long>,
		JpaSpecificationExecutor<DateTimeWithSecondsDrillDownEntity> {

}