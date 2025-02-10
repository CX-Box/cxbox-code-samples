package org.demo.documentation.widgets.picklist.actions.cancelcreate.oncancel;

import org.demo.documentation.widgets.picklist.actions.cancelcreate.basic.MyEntity3198Pick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3198PickOnCancelRepository extends JpaRepository<MyEntity3198PickOnCancel, Long>, JpaSpecificationExecutor<MyEntity3198PickOnCancel> {

}
