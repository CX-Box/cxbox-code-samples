package org.demo.documentation.widgets.picklist.title.withouttitle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3069PickRepository extends JpaRepository<MyEntity3069Pick, Long>, JpaSpecificationExecutor<MyEntity3069Pick> {

}
