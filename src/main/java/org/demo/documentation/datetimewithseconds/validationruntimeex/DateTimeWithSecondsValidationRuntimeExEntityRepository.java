package org.demo.documentation.datetimewithseconds.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsValidationRuntimeExEntityRepository extends
		JpaRepository<DateTimeWithSecondsValidationRuntimeExEntity, Long>,
		JpaSpecificationExecutor<DateTimeWithSecondsValidationRuntimeExEntity> {

}