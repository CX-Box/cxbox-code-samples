package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3175MultiRepository extends JpaRepository<MyEntity3175Multi, Long>, JpaSpecificationExecutor<MyEntity3175Multi> {

}
