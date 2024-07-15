package org.demo.documentation.fields.datetime.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeColorRepository extends JpaRepository<DateTimeColor, Long>,
		JpaSpecificationExecutor<DateTimeColor> {

}