package org.demo.documentation.fields.datetimewithseconds.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsEntityRepository extends JpaRepository<DateTimeWithSecondsEntity, Long>,
		JpaSpecificationExecutor<DateTimeWithSecondsEntity> {

}