package org.demo.documentation.widgets.picklist.actions.create;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3072PickRepository extends JpaRepository<MyEntity3072Pick, Long>, JpaSpecificationExecutor<MyEntity3072Pick> {

}
