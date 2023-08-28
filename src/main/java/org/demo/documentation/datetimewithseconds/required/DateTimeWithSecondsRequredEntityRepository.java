package org.demo.documentation.datetimewithseconds.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsRequredEntityRepository extends
		JpaRepository<DateTimeWithSecondsRequredEntity, Long>, JpaSpecificationExecutor<DateTimeWithSecondsRequredEntity> {

}