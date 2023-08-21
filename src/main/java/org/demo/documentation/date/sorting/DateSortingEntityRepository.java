package org.demo.documentation.date.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateSortingEntityRepository extends JpaRepository<DateSortingEntity, Long>,
		JpaSpecificationExecutor<DateSortingEntity> {

}