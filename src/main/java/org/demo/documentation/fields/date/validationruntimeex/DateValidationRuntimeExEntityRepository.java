package org.demo.documentation.fields.date.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateValidationRuntimeExEntityRepository extends JpaRepository<DateValidationRuntimeExEntity, Long>,
		JpaSpecificationExecutor<DateValidationRuntimeExEntity> {

}