package org.demo.documentation.widgets.picklist.customizationcolumns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3089PickRepository extends JpaRepository<MyEntity3089Pick, Long>, JpaSpecificationExecutor<MyEntity3089Pick> {

}
