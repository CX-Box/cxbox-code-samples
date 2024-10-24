package org.demo.documentation.widgets.form.actions.create.withview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3302Repository extends JpaRepository<MyEntity3302, Long>, JpaSpecificationExecutor<MyEntity3302> {

}
