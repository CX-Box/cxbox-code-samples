package org.demo.documentation.date.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DatePlaceholderEntityRepository extends JpaRepository<DatePlaceholderEntity, Long>,
		JpaSpecificationExecutor<DatePlaceholderEntity> {

}