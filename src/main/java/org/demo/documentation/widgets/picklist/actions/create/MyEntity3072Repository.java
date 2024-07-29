package org.demo.documentation.widgets.picklist.actions.create;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3072Repository extends JpaRepository<MyEntity3072, Long>, JpaSpecificationExecutor<MyEntity3072> {

}
