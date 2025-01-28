package org.demo.documentation.widgets.picklist.actions.cancelcreate.forpicklistpopup;

import org.demo.documentation.widgets.picklist.actions.cancelcreate.MyEntity3198;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3198PickRepository extends JpaRepository<MyEntity3198Pick, Long>, JpaSpecificationExecutor<MyEntity3198Pick> {

}
