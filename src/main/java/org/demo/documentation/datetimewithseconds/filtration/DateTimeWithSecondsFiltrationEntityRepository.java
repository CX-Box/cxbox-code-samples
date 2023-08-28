package org.demo.documentation.datetimewithseconds.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeWithSecondsFiltrationEntityRepository extends
		JpaRepository<DateTimeWithSecondsFiltrationEntity, Long>,
		JpaSpecificationExecutor<DateTimeWithSecondsFiltrationEntity> {

}