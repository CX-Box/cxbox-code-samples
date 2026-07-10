package org.demo.documentation.widgets.pie1d.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntityRingRepository extends JpaRepository<MyEntityRingData, Long>, JpaSpecificationExecutor<MyEntityRingData> {
	@Query("SELECT SUM(customFieldNum) FROM MyEntityRingData group by customField")
	Long customTotal();

	@Query("""
			SELECT new org.demo.documentation.widgets.pie1d.data.CustomPrj(
			min(id),
			customField,
			SUM(customFieldNum) ,
			min(customFieldDictionary),
			min(customFieldDate))
			FROM MyEntityRingData
			GROUP BY customField
			""")
	List<CustomPrj> getCustomPrj();

}
