package org.demo.documentation.widgets.tree.colortitle;

import org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267Picklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3267PickRepository extends JpaRepository<MyEntity3267Picklist, Long>, JpaSpecificationExecutor<MyEntity3267Picklist> {

}
