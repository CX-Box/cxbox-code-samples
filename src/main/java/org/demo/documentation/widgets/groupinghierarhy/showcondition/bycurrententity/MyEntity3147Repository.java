package org.demo.documentation.widgets.groupinghierarhy.showcondition.bycurrententity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3147Repository extends JpaRepository<MyEntity3147, Long>, JpaSpecificationExecutor<MyEntity3147> {

}
