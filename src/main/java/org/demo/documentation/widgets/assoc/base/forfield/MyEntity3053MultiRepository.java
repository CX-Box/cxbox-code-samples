package org.demo.documentation.widgets.assoc.base.forfield;

import org.demo.documentation.widgets.assoc.base.MyEntity3053;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3053MultiRepository extends JpaRepository<MyEntity3053Multi, Long>, JpaSpecificationExecutor<MyEntity3053Multi> {

}
