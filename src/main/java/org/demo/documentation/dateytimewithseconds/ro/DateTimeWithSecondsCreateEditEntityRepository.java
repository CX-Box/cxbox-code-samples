package org.demo.documentation.dateytimewithseconds.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsCreateEditEntityRepository extends
		JpaRepository<DateTimeWithSecondsCreateEditEntity, Long>,
		JpaSpecificationExecutor<DateTimeWithSecondsCreateEditEntity> {

}