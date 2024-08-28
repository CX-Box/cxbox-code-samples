package org.demo.documentation.widgets.assoc.colortitle.allfields;

import org.demo.documentation.widgets.assoc.colortitle.allfields.forfields.MyEntity3052Picklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3052PicklitsAssocRepository extends JpaRepository<MyEntity3052Picklist, Long>, JpaSpecificationExecutor<MyEntity3052Picklist> {

}
