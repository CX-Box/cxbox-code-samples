package org.demo.documentation.widgets.groupinghierarhy.actions.edit.withwidget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3168Repository extends JpaRepository<MyEntity3168, Long>, JpaSpecificationExecutor<MyEntity3168> {

}
