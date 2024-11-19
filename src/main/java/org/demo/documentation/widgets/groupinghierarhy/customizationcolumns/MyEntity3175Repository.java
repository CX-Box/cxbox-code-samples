package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3175Repository extends JpaRepository<MyEntity3175, Long>, JpaSpecificationExecutor<MyEntity3175> {

}
