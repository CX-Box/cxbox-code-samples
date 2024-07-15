package org.demo.documentation.fields.number.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberConfirmEntityRepository extends JpaRepository<NumberConfirmEntity, Long>,
		JpaSpecificationExecutor<NumberConfirmEntity> {

}