package org.demo.documentation.fields.number.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberColorConstEntityRepository extends JpaRepository<NumberColorConstEntity, Long>,
		JpaSpecificationExecutor<NumberColorConstEntity> {

}