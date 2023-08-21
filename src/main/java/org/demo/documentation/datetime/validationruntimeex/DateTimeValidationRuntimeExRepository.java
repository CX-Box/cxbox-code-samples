package org.demo.documentation.datetime.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeValidationRuntimeExRepository extends JpaRepository<DateTimeValidationRuntimeEx, Long>,
		JpaSpecificationExecutor<DateTimeValidationRuntimeEx> {

}