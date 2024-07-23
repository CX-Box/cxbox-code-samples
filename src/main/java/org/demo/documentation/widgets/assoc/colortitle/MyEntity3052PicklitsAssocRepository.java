package org.demo.documentation.widgets.assoc.colortitle;

import org.demo.documentation.widgets.assoc.colortitle.forfields.MyEntity3052Picklist;
import org.demo.documentation.widgets.assoc.colortitle.forfields.MyEntity3052PicklistAssoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3052PicklitsAssocRepository extends JpaRepository<MyEntity3052Picklist, Long>, JpaSpecificationExecutor<MyEntity3052Picklist> {

}
