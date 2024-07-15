package org.demo.documentation.fields.number.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberPlaceholderEntityRepository extends JpaRepository<NumberPlaceholderEntity, Long>,
		JpaSpecificationExecutor<NumberPlaceholderEntity> {

}