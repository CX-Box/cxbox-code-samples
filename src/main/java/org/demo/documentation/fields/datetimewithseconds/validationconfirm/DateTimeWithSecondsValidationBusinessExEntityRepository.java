package org.demo.documentation.fields.datetimewithseconds.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsValidationBusinessExEntityRepository extends
		JpaRepository<DateTimeWithSecondsValidationBusinessExEntity, Long>,
		JpaSpecificationExecutor<DateTimeWithSecondsValidationBusinessExEntity> {

}