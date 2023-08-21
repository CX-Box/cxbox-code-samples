package org.demo.documentation.dateytimewithseconds.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsSortingEntityRepository extends
		JpaRepository<DateTimeWithSecondsSortingEntity, Long>, JpaSpecificationExecutor<DateTimeWithSecondsSortingEntity> {

}