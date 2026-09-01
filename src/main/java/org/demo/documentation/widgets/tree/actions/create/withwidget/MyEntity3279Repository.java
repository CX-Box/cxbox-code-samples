package org.demo.documentation.widgets.tree.actions.create.withwidget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3279Repository extends JpaRepository<MyEntity3279, Long>, JpaSpecificationExecutor<MyEntity3279> {
	boolean existsByParentId(String parentId);
}
