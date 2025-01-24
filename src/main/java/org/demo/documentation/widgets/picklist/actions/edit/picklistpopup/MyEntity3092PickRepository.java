package org.demo.documentation.widgets.picklist.actions.edit.picklistpopup;

import org.demo.documentation.widgets.picklist.actions.edit.MyEntity3092;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3092PickRepository extends JpaRepository<MyEntity3092Pick, Long>, JpaSpecificationExecutor<MyEntity3092Pick> {

}
