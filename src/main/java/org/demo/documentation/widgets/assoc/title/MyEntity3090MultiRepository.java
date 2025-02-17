package org.demo.documentation.widgets.assoc.title;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3090MultiRepository extends JpaRepository<MyEntity3090Multi, Long>, JpaSpecificationExecutor<MyEntity3090Multi> {

}
