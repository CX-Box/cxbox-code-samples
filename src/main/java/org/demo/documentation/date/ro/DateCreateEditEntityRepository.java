package org.demo.documentation.date.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateCreateEditEntityRepository extends JpaRepository<DateCreateEditEntity, Long>,
		JpaSpecificationExecutor<DateCreateEditEntity> {

}