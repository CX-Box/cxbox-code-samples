package org.demo.documentation.fields.datetimewithseconds.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsColorConstEntityRepository extends
		JpaRepository<DateTimeWithSecondsColorConstEntity, Long>,
		JpaSpecificationExecutor<DateTimeWithSecondsColorConstEntity> {

}