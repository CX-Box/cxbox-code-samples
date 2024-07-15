package org.demo.documentation.fields.datetime.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeBasicRepository extends JpaRepository<DateTimeBasic, Long>,
		JpaSpecificationExecutor<DateTimeBasic> {

}