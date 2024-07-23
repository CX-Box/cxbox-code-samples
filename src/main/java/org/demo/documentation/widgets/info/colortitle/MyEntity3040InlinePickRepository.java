package org.demo.documentation.widgets.info.colortitle;

import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040InlinePicklist;
import org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Picklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3040InlinePickRepository extends JpaRepository<MyEntity3040InlinePicklist, Long>, JpaSpecificationExecutor<MyEntity3040InlinePicklist> {

}
