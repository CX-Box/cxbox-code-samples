package org.demo.documentation.fields.number.additionalproperties.digits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitsNumberEntityRepository extends JpaRepository<DigitsNumberEntity, Long>,
		JpaSpecificationExecutor<DigitsNumberEntity> {

}