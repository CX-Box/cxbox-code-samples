package org.demo.documentation.feature.postaction.drilldownandwaituntil.basic;

import org.demo.documentation.feature.postaction.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity3234Repository extends JpaRepository<MyEntity3234, Long>, JpaSpecificationExecutor<MyEntity3234> {

	List<MyEntity3234> findAllByStatusResponse(StatusEnum customField);
}