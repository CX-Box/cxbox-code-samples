package org.demo.documentation.datetime.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeValidationBusinessExRepository extends JpaRepository<DateTimeValidationBusinessEx, Long>,
		JpaSpecificationExecutor<DateTimeValidationBusinessEx> {

}