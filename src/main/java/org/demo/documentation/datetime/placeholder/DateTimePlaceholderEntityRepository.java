package org.demo.documentation.datetime.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimePlaceholderEntityRepository extends JpaRepository<DateTimePlaceholderEntity, Long>,
		JpaSpecificationExecutor<DateTimePlaceholderEntity> {

}