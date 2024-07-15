package org.demo.documentation.fields.datetime.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeColorCalcRepository extends JpaRepository<DateTimeColorCalc, Long>,
		JpaSpecificationExecutor<DateTimeColorCalc> {

}