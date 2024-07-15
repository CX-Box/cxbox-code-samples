package org.demo.documentation.fields.number.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberRequiredEntityRepository extends JpaRepository<NumberRequiredEntity, Long>,
		JpaSpecificationExecutor<NumberRequiredEntity> {

}