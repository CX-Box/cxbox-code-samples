package org.demo.documentation.feature.postaction.waituntil.basic;

import org.demo.documentation.feature.postaction.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity3233Repository extends JpaRepository<MyEntity3233, Long>, JpaSpecificationExecutor<MyEntity3233> {
	List<MyEntity3233> findAllByStatusResponse(StatusEnum customField);
}
