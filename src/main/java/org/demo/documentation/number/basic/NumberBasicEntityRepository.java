package org.demo.documentation.number.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberBasicEntityRepository extends JpaRepository<NumberBasicEntity, Long>,
		JpaSpecificationExecutor<NumberBasicEntity> {

}