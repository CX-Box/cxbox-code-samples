package org.demo.documentation.dateytimewithseconds.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsColorEntityRepository extends JpaRepository<DateTimeWithSecondsColorEntity, Long>,
		JpaSpecificationExecutor<DateTimeWithSecondsColorEntity> {

}