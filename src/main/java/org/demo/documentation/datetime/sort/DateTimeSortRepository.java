package org.demo.documentation.datetime.sort;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeSortRepository extends JpaRepository<DateTimeSort, Long>,
		JpaSpecificationExecutor<DateTimeSort> {

}