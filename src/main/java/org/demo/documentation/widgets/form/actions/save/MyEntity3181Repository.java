package org.demo.documentation.widgets.form.actions.save;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3181Repository extends JpaRepository<MyEntity3181, Long>, JpaSpecificationExecutor<MyEntity3181> {

}
