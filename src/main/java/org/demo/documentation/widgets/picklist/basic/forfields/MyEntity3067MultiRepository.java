package org.demo.documentation.widgets.picklist.basic.forfields;

import org.demo.documentation.widgets.picklist.basic.MyEntity3067;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3067MultiRepository extends JpaRepository<MyEntity3067Multi, Long>, JpaSpecificationExecutor<MyEntity3067Multi> {

}
