package org.demo.documentation.widgets.form.base.allfields.forfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3010MultiHoverRepository extends JpaRepository<MyEntity3010MultiHover, Long>, JpaSpecificationExecutor<MyEntity3010MultiHover> {

}
