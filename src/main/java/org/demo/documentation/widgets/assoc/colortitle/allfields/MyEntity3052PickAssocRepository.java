package org.demo.documentation.widgets.assoc.colortitle.allfields;

import org.demo.documentation.widgets.assoc.colortitle.allfields.forfields.MyEntity3052PicklistAssoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3052PickAssocRepository extends JpaRepository<MyEntity3052PicklistAssoc, Long>, JpaSpecificationExecutor<MyEntity3052PicklistAssoc> {

}
