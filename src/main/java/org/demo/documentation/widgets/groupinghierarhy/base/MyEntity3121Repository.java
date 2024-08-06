package org.demo.documentation.widgets.groupinghierarhy.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3121Repository extends JpaRepository<MyEntity3121, Long>, JpaSpecificationExecutor<MyEntity3121> {

}
