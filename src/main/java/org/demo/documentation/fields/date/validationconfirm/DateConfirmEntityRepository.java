package org.demo.documentation.fields.date.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateConfirmEntityRepository extends JpaRepository<DateConfirmEntity, Long>,
		JpaSpecificationExecutor<DateConfirmEntity> {

}