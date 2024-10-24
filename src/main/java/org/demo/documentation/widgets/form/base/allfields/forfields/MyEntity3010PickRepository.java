package org.demo.documentation.widgets.form.base.allfields.forfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3010PickRepository extends JpaRepository<MyEntity3010Pick, Long>, JpaSpecificationExecutor<MyEntity3010Pick> {

}
