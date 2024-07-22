package org.demo.documentation.widgets.list.colortitle;

import org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050Picklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3050PickRepository extends JpaRepository<MyEntity3050Picklist, Long>, JpaSpecificationExecutor<MyEntity3050Picklist> {

}
