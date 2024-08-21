package org.demo.documentation.widgets.assoc.actions.customsave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3063MultiRepository extends JpaRepository<MyEntity3063Multi, Long>, JpaSpecificationExecutor<MyEntity3063Multi> {

}
