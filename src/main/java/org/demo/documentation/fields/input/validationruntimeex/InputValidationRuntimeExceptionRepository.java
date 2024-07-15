package org.demo.documentation.fields.input.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputValidationRuntimeExceptionRepository extends JpaRepository<InputValidationRuntimeException, Long>,
		JpaSpecificationExecutor<InputValidationRuntimeException> {

}