package org.demo.documentation.feature.postaction.drilldownandwaituntil.allbutton;

import org.demo.documentation.feature.postaction.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity3232Repository extends JpaRepository<MyEntity3232, Long>, JpaSpecificationExecutor<MyEntity3232> {

	List<MyEntity3232> findAllByStatusResponse(StatusEnum customField);
}
