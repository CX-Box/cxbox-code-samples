package org.demo.documentation.fields.input.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputValidationBusinessExceptionRepository extends JpaRepository<InputValidationBusinessExc, Long>,
		JpaSpecificationExecutor<InputValidationBusinessExc> {

}