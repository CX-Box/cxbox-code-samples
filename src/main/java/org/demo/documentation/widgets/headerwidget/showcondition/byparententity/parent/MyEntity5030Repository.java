package org.demo.documentation.widgets.headerwidget.showcondition.byparententity.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5030Repository extends JpaRepository<MyEntity5030, Long>, JpaSpecificationExecutor<MyEntity5030> {

}
