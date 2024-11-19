package org.demo.documentation.widgets.groupinghierarhy.actions.create.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3148Repository extends JpaRepository<MyEntity3148, Long>, JpaSpecificationExecutor<MyEntity3148> {

}
