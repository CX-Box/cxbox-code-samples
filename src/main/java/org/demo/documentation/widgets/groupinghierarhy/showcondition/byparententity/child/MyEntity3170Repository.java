package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3170Repository extends JpaRepository<MyEntity3170, Long>, JpaSpecificationExecutor<MyEntity3170> {

}
