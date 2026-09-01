package org.demo.documentation.widgets.tree.showcondition.byparententity.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3277Repository extends JpaRepository<MyEntity3277, Long>, JpaSpecificationExecutor<MyEntity3277> {
	boolean existsByParentTreeId(String parentId);
}