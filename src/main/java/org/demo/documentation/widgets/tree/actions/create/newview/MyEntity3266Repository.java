package org.demo.documentation.widgets.tree.actions.create.newview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3266Repository extends JpaRepository<MyEntity3266, Long>, JpaSpecificationExecutor<MyEntity3266> {
	boolean existsByParentId(String parentId);
}
