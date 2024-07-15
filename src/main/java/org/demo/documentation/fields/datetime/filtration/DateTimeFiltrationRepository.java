package org.demo.documentation.fields.datetime.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeFiltrationRepository extends JpaRepository<DateTimeFiltration, Long>,
		JpaSpecificationExecutor<DateTimeFiltration> {

}