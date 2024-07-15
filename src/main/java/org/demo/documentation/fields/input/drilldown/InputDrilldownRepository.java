package org.demo.documentation.fields.input.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputDrilldownRepository extends JpaRepository<InputDrilldown, Long>,
		JpaSpecificationExecutor<InputDrilldown> {

}