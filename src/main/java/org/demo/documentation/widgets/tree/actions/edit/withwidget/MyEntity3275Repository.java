package org.demo.documentation.widgets.tree.actions.edit.withwidget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3275Repository extends JpaRepository<MyEntity3275, Long>, JpaSpecificationExecutor<MyEntity3275> {
	boolean existsByParentId(String parentId);
}
