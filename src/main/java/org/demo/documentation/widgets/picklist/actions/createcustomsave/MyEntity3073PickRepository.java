package org.demo.documentation.widgets.picklist.actions.createcustomsave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3073PickRepository extends JpaRepository<MyEntity3073Pick, Long>, JpaSpecificationExecutor<MyEntity3073Pick> {

}
