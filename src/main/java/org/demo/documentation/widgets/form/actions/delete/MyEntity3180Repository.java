package org.demo.documentation.widgets.form.actions.delete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3180Repository extends JpaRepository<MyEntity3180, Long>, JpaSpecificationExecutor<MyEntity3180> {

}
