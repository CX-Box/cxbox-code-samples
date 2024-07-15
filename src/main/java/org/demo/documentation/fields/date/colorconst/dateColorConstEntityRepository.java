package org.demo.documentation.fields.date.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface dateColorConstEntityRepository extends JpaRepository<dateColorConstEntity, Long>,
		JpaSpecificationExecutor<dateColorConstEntity> {

}