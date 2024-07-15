package org.demo.documentation.fields.number.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRuntimeExEntityRepository extends JpaRepository<NumberRuntimeExEntity, Long>,
		JpaSpecificationExecutor<NumberRuntimeExEntity> {

}