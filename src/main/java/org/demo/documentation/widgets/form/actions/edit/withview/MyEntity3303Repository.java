package org.demo.documentation.widgets.form.actions.edit.withview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3303Repository extends JpaRepository<MyEntity3303, Long>, JpaSpecificationExecutor<MyEntity3303> {

}
