package org.demo.documentation.fields.datetime.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RequiredDateTimeRepository extends JpaRepository<RequiredDateTime, Long>,
		JpaSpecificationExecutor<RequiredDateTime> {

}