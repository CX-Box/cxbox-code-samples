package org.demo.documentation.widgets.picklist.fieldslayoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3070PickRepository extends JpaRepository<MyEntity3070Pick, Long>, JpaSpecificationExecutor<MyEntity3070Pick> {

}
