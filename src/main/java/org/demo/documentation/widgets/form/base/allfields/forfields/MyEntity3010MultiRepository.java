package org.demo.documentation.widgets.form.base.allfields.forfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3010MultiRepository extends JpaRepository<MyEntity3010Multi, Long>, JpaSpecificationExecutor<MyEntity3010Multi> {

}
