package org.demo.documentation.widgets.picklist.allpropertiesfield.forpicklistpopup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3405PickRepository extends JpaRepository<MyEntity3405PickListPopup, Long>, JpaSpecificationExecutor<MyEntity3405PickListPopup> {

}
