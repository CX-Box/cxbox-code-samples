package org.demo.documentation.widgets.picklist.actions.create.inlinepicklist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3072InlinePickRepository extends JpaRepository<MyEntity3072InlinePick, Long>, JpaSpecificationExecutor<MyEntity3072InlinePick> {

}
