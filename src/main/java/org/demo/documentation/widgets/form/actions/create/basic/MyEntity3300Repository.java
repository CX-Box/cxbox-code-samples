package org.demo.documentation.widgets.form.actions.create.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3300Repository extends JpaRepository<MyEntity3300, Long>, JpaSpecificationExecutor<MyEntity3300> {

}
