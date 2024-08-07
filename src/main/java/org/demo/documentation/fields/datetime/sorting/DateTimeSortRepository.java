package org.demo.documentation.fields.datetime.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeSortRepository extends JpaRepository<DateTimeSort, Long>,
		JpaSpecificationExecutor<DateTimeSort> {

}