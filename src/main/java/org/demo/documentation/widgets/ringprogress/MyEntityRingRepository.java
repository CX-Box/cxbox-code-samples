package org.demo.documentation.widgets.ringprogress;

import org.demo.documentation.widgets.statsblock.base.data.MyEntity4201;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityRingRepository extends JpaRepository<MyEntityRingData, Long>, JpaSpecificationExecutor<MyEntity4201> {
	@Query("SELECT SUM(customFieldNum) FROM MyEntityRingData")
	Long customTotal();


}