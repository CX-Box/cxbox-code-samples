package org.demo.documentation.fields.input.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputValidationRepository extends JpaRepository<InputValidation, Long>,
		JpaSpecificationExecutor<InputValidation> {

}