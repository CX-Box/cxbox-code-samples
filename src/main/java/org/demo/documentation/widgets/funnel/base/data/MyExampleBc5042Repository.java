package org.demo.documentation.widgets.funnel.base.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MyExampleBc5042Repository extends JpaRepository<MyExampleBc5042, Long>, JpaSpecificationExecutor<MyExampleBc5042> {

	@Query("SELECT SUM(customFieldNum) FROM MyExampleBc5042")
	Long customTotal();

}
