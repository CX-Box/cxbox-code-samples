package org.demo.documentation.fields.datetime.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeValidationRepository extends JpaRepository<DateTimeValidation, Long>,
		JpaSpecificationExecutor<DateTimeValidation> {

}