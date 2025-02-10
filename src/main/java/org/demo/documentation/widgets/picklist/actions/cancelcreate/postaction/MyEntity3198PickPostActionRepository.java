package org.demo.documentation.widgets.picklist.actions.cancelcreate.postaction;

import org.demo.documentation.widgets.picklist.actions.cancelcreate.basic.MyEntity3198Pick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3198PickPostActionRepository extends JpaRepository<MyEntity3198PickPostAction, Long>, JpaSpecificationExecutor<MyEntity3198PickPostAction> {

}
