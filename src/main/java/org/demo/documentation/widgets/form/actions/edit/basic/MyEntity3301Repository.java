package org.demo.documentation.widgets.form.actions.edit.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3301Repository extends JpaRepository<MyEntity3301, Long>, JpaSpecificationExecutor<MyEntity3301> {

}
