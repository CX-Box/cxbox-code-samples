package org.demo.documentation.fields.number.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberCreateEditEntityRepository extends JpaRepository<NumberCreateEditEntity, Long>,
		JpaSpecificationExecutor<NumberCreateEditEntity> {

}