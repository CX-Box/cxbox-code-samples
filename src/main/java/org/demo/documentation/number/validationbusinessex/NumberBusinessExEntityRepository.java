package org.demo.documentation.number.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberBusinessExEntityRepository extends JpaRepository<NumberBusinessExEntity, Long>,
		JpaSpecificationExecutor<NumberBusinessExEntity> {

}