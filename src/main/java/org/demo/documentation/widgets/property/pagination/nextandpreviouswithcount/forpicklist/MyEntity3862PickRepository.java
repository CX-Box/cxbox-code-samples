package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forpicklist;

import org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.MyEntity3862;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3862PickRepository extends JpaRepository<MyEntity3862Pick, Long>, JpaSpecificationExecutor<MyEntity3862Pick> {

}
