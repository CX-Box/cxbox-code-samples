package org.demo.documentation.number.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface NumberSortingEntityRepository extends JpaRepository<NumberSortingEntity, Long>,
		JpaSpecificationExecutor<NumberSortingEntity> {

}