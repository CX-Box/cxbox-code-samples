package org.demo.documentation.widgets.picklist.actions.edit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3092Repository extends JpaRepository<MyEntity3092, Long>, JpaSpecificationExecutor<MyEntity3092> {

}
