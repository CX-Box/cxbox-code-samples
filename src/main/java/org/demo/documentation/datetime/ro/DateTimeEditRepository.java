package org.demo.documentation.datetime.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeEditRepository extends JpaRepository<DateTimeEdit, Long>,
		JpaSpecificationExecutor<DateTimeEdit> {

}