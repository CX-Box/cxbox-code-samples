package org.demo.documentation.widgets.groupinghierarhy.counter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3201Repository extends JpaRepository<MyEntity3201, Long>, JpaSpecificationExecutor<MyEntity3201> {

}
