package org.demo.documentation.fields.date.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateValidationBusinessExEntityRepository extends JpaRepository<DateValidationBusinessExEntity, Long>,
		JpaSpecificationExecutor<DateValidationBusinessExEntity> {

}