package org.demo.documentation.widgets.tree.actions.edit.newview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3274Repository extends JpaRepository<MyEntity3274, Long>, JpaSpecificationExecutor<MyEntity3274> {
	boolean existsByParentId(String parentId);
}
