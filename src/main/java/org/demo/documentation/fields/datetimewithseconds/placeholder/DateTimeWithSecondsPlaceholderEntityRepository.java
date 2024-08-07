package org.demo.documentation.fields.datetimewithseconds.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsPlaceholderEntityRepository extends
		JpaRepository<DateTimeWithSecondsPlaceholderEntity, Long>,
		JpaSpecificationExecutor<DateTimeWithSecondsPlaceholderEntity> {

}