package org.demo.documentation.date.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRequiredEntityRepository extends JpaRepository<DateRequiredEntity, Long>,
		JpaSpecificationExecutor<DateRequiredEntity> {

}